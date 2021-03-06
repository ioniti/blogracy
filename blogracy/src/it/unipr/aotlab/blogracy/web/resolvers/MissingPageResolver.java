/*
 * Copyright (c)  2011 Enrico Franchi, Michele Tomaiuolo and University of Parma.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package it.unipr.aotlab.blogracy.web.resolvers;

import it.unipr.aotlab.blogracy.errors.URLMappingError;
import org.gudy.azureus2.plugins.tracker.web.TrackerWebPageRequest;
import org.gudy.azureus2.plugins.tracker.web.TrackerWebPageResponse;

import java.net.HttpURLConnection;

/**
 * User: enrico
 * Package: it.unipr.aotlab.blogracy.web
 * Date: 11/3/11
 * Time: 10:36 AM
 */

public class MissingPageResolver implements RequestResolver {
    final private String message;

    public MissingPageResolver(final String url) {
        message = "Cannot find resolver for url " + url;
    }

    @Override
    public void resolve(final TrackerWebPageRequest request, final TrackerWebPageResponse response) throws URLMappingError {
        ErrorPageResolver errorPageResolver = new ErrorPageResolver(
                new URLMappingError(HttpURLConnection.HTTP_NOT_FOUND, message)
        );
        errorPageResolver.resolve(request, response);
    }

    @Override
   public HTTPStatus getRequestHTTPStatus() {
       throw new UnsupportedOperationException();
   }

   @Override
   public boolean isAJAXRequest(final TrackerWebPageRequest request) {
       throw new UnsupportedOperationException();
       }
}
