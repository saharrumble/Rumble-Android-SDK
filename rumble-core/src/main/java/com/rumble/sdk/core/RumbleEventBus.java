package com.rumble.sdk.core;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import de.greenrobot.event.EventBus;

/**
 * Created by saharkroglen on 6/1/15.
 */
public class RumbleEventBus  extends EventBus {

    private static EventBus mRumbleDefaultInstance;

    /** Convenience singleton for apps using a process-wide EventBus instance. */
    public static EventBus getRumbleInstance() {
        if (mRumbleDefaultInstance == null) {
            synchronized (EventBus.class) {
                if (mRumbleDefaultInstance == null) {
                    mRumbleDefaultInstance = new EventBus();
                }
            }
        }
        return mRumbleDefaultInstance;
    }

    public static void doNetrowk(Context c, final String url)
    {
        RequestQueue mRequestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(c.getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

// Start the queue
        mRequestQueue.start();

        //String url ="http://www.myurl.com";

// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("network", "response from: " + url + " data: " + response.substring(0, 200));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("network", error.getMessage());
                    }
                });

// Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);
    }

}
