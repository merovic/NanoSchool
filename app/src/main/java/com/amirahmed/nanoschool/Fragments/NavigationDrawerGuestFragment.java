package com.amirahmed.nanoschool.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.GuestLogin.DistanceSelectionActivity;
import com.amirahmed.nanoschool.Activities.GuestLogin.GuestSettingActivity;
import com.amirahmed.nanoschool.Activities.GuestLogin.NotificationsSettingActivity;
import com.amirahmed.nanoschool.Activities.HelpActivity;
import com.amirahmed.nanoschool.Activities.NewAboutApplicationActivity;
import com.amirahmed.nanoschool.Activities.SettingActivity;
import com.amirahmed.nanoschool.Adapters.NavigationDrawerAdapter;
import com.amirahmed.nanoschool.Models.NavigationItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.NavigationDrawerCallbacks;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerGuestFragment extends Fragment implements NavigationDrawerCallbacks {

    /**
     * Remember the position of the selected item.
     */
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    /**
     * A pointer to the current callbacks instance (the Activity).
     */
    private NavigationDrawerCallbacks mCallbacks;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    TinyDB tinyDB;

    int language;

    View view;

    LinearLayout languagetap,notificationstap,distancetab,contactustab,aboutustab;

    TextView text1,text2,text3,text4,text5,title1,title2;

    ImageView arrow1,arrow2,arrow3,arrow4,arrow5;

    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read in the flag indicating whether or not the user has demonstrated awareness of the
        // drawer. See PREF_USER_LEARNED_DRAWER for details.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tinyDB = new TinyDB(getActivity());
        language = tinyDB.getInt("language");

        if (language==1)
        {
            view = inflater.inflate(R.layout.fragment_navigation_drawer_guest, container, false);

        }else
        {
            view = inflater.inflate(R.layout.fragment_navigation_drawer_guest, container, false);

        }
        mDrawerList = view.findViewById(R.id.drawerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDrawerList.setLayoutManager(layoutManager);
        mDrawerList.setHasFixedSize(true);

        final List<NavigationItem> navigationItems = getMenu();
        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(navigationItems);
        adapter.setNavigationDrawerCallbacks(this);
        mDrawerList.setAdapter(adapter);
        //selectItem(mCurrentSelectedPosition);

        adapter.notifyDataSetChanged();

        languagetap = view.findViewById(R.id.languagetap);
        notificationstap = view.findViewById(R.id.notificationstap);
        distancetab = view.findViewById(R.id.distancetap);
        contactustab = view.findViewById(R.id.contactustap);
        aboutustab = view.findViewById(R.id.aboutustap);

        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        text3 = view.findViewById(R.id.text3);
        text4 = view.findViewById(R.id.text4);
        text5 = view.findViewById(R.id.text5);

        title1 = view.findViewById(R.id.title1);
        title2 = view.findViewById(R.id.title2);

        arrow1 = view.findViewById(R.id.arrow1);
        arrow2 = view.findViewById(R.id.arrow2);
        arrow3 = view.findViewById(R.id.arrow3);
        arrow4 = view.findViewById(R.id.arrow4);
        arrow5 = view.findViewById(R.id.arrow5);

        login = view.findViewById(R.id.loginbutton);

        if(language!=1)
        {
            languagetap.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            notificationstap.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            distancetab.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            contactustab.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            aboutustab.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            text1.setText("Language");
            text2.setText("Notifications");
            text3.setText("Distance");
            text4.setText("Contact us");
            text5.setText("About Us");

            title1.setText("Setting");
            title2.setText("Information");

            arrow1.setRotation(270);
            arrow2.setRotation(270);
            arrow3.setRotation(270);
            arrow4.setRotation(270);
            arrow5.setRotation(270);

            login.setText("Signup");
        }

        languagetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                Intent intent = new Intent(getActivity(),GuestSettingActivity.class);
                getActivity().startActivity(intent);
            }
        });

        notificationstap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                Intent intent = new Intent(getActivity(),NotificationsSettingActivity.class);
                getActivity().startActivity(intent);
            }
        });

        distancetab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                Intent intent = new Intent(getActivity(),DistanceSelectionActivity.class);
                getActivity().startActivity(intent);
            }
        });

        contactustab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                Intent intent = new Intent(getActivity(),HelpActivity.class);
                getActivity().startActivity(intent);
            }
        });

        aboutustab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                Intent intent = new Intent(getActivity(),NewAboutApplicationActivity.class);
                getActivity().startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();

                final FragmentManager fm = getFragmentManager();
                LoginFragment loginFragment = new LoginFragment();

                loginFragment.show(fm,"TV_tag");
            }
        });

        return view;
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle() {
        return mActionBarDrawerToggle;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        selectItem(position);
    }

    public List<NavigationItem> getMenu() {
        List<NavigationItem> items = new ArrayList<>();
        if(language==1)
        {
            items.add(new NavigationItem("التقويم الدراسى", getResources().getDrawable(R.drawable.calendarmenu)));
            items.add(new NavigationItem("قائمتى المفضلة", getResources().getDrawable(R.drawable.favorite)));
            //items.add(new NavigationItem("عن التطبيق", getResources().getDrawable(R.drawable.about)));
            //items.add(new NavigationItem("المساعدة", getResources().getDrawable(R.drawable.help)));
            //items.add(new NavigationItem("الاعدادات", getResources().getDrawable(R.drawable.setting)));
            //items.add(new NavigationItem("مشاركة", getResources().getDrawable(R.drawable.sharenew)));
            //items.add(new NavigationItem("قيمنا", getResources().getDrawable(R.drawable.rate)));
        }else
        {
            items.add(new NavigationItem("Calender", getResources().getDrawable(R.drawable.calendarmenu)));
            items.add(new NavigationItem("Favorite List", getResources().getDrawable(R.drawable.favorite)));
            //items.add(new NavigationItem("About", getResources().getDrawable(R.drawable.about)));
            //items.add(new NavigationItem("Help", getResources().getDrawable(R.drawable.help)));
            //items.add(new NavigationItem("Setting", getResources().getDrawable(R.drawable.setting)));
            //items.add(new NavigationItem("Share", getResources().getDrawable(R.drawable.sharenew)));
            //items.add(new NavigationItem("Rate us", getResources().getDrawable(R.drawable.rate)));
        }

        return items;
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     * @param toolbar      The Toolbar of the activity.
     */
    public void setup(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mFragmentContainerView = (View) getActivity().findViewById(fragmentId).getParent();
        mDrawerLayout = drawerLayout;

        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.myPrimaryDarkColor));

        mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) return;

                getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) return;
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }
                getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
        // per the navigation drawer design guidelines.
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
        ((NavigationDrawerAdapter) mDrawerList.getAdapter()).selectPosition(position);
    }

    public void openDrawer() {
        mDrawerLayout.openDrawer(mFragmentContainerView);
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawer(mFragmentContainerView);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

}
