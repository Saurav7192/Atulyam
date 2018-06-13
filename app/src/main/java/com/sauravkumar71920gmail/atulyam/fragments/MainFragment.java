package com.sauravkumar71920gmail.atulyam.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sauravkumar71920gmail.atulyam.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Activity contex = getActivity();
        TabLayout tabLayout = (TabLayout)contex.findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)contex.findViewById(R.id.viewPager);

        CustomPagerAdaptor pagerAdaptor = new CustomPagerAdaptor(getChildFragmentManager());
        pagerAdaptor.addFragment(new MegaFragment(),"Mega Event");
        pagerAdaptor.addFragment(new CreativeFragment(),"Creative Event");
        pagerAdaptor.addFragment(new LiteraryFragment(),"Literary Event");
        pagerAdaptor.addFragment(new LanFragment(),"Lan Games");
        pagerAdaptor.addFragment(new FunFragment(),"Fun Event");

        viewPager.setAdapter(pagerAdaptor);

        tabLayout.setupWithViewPager(viewPager);


    }
    public class CustomPagerAdaptor extends FragmentPagerAdapter {
        public ArrayList<Fragment> mFragments = new ArrayList<>();
        public ArrayList<String> mFragmentTitles = new ArrayList<>();

        public CustomPagerAdaptor(FragmentManager fm){
            super(fm);
        }
        public void addFragment(Fragment fragment, String title){
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position){
            return mFragments.get(position);
        }
        @Override
        public int getCount(){
            return mFragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position){
            return  mFragmentTitles.get(position);
        }
    }


}
