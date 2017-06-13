package id.sch.smktelkom_mlg.privateassignment.xirpl523.tugaspribadi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.adapter.popular;
import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.model.ResultsRespons;
import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {


    ArrayList<Results> mlist = new ArrayList<>();
    popular myPopular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_popular);
        rv.setHasFixedSize(true);
        myPopular = new popular(this, mlist, getContext());
        rv.setAdapter(myPopular);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataResource();

        return rootView;
    }

    private void downloadDataResource() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=f5203c197b2af435b78315acb9ae10b6&language=en-US&page=1";

        GsonGetRequest<ResultsRespons> myRequest = new GsonGetRequest<ResultsRespons>
                (url, ResultsRespons.class, null, new Response.Listener<ResultsRespons>() {

                    @Override
                    public void onResponse(ResultsRespons response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        mlist.addAll(response.results);
                        myPopular.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }
}
