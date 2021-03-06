/**************************************************
 * Android Web Server
 * Based on JavaLittleWebServer (2008)
 * <p/>
 * Copyright (c) Piotr Polak 2008-2015
 **************************************************/

package ro.polak.http.resource.provider;

import java.io.IOException;

import ro.polak.http.servlet.impl.HttpRequestImpl;
import ro.polak.http.servlet.impl.HttpResponseImpl;

/**
 * Interface used for loading certain types of HTTP resources
 *
 * @author Piotr Polak piotr [at] polak [dot] ro
 * @since 201610
 */
public interface ResourceProvider {

    /**
     * Tells whether this resource provider can load such a resource.
     *
     * @param path
     * @return
     */
    boolean canLoad(String path);

    /**
     * Loads the resource by URI, returns true if the resource was found or an error was served
     *
     * @param path
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    void load(String path, HttpRequestImpl request, HttpResponseImpl response) throws IOException;

    /**
     * Shuts down the resource provider, closes all open resources.
     */
    void shutdown();
}
