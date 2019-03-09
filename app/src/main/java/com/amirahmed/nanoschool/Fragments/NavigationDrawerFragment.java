package com.amirahmed.nanoschool.Fragments;

import android.app.Activity;
import android.app.Fragment;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.NavigationDrawerAdapter;
import com.amirahmed.nanoschool.Models.NavigationItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.NavigationDrawerCallbacks;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends Fragment implements NavigationDrawerCallbacks,AdapterView.OnItemSelectedListener {

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

    Spinner sp;

    List<String> requests = new ArrayList<>();

    View view;

    TextView studentname;

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
            view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

            requests.add("احمد");
            requests.add("محمود");

        }else
        {
            view = inflater.inflate(R.layout.fragment_navigation_drawer_en, container, false);

            requests.add("Ahmed");
            requests.add("Mahmoud");
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



        sp = view.findViewById(R.id.requests);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, requests);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter2);
        sp.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();

        studentname = view.findViewById(R.id.studentname);

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
            items.add(new NavigationItem("حسابى", getResources().getDrawable(R.drawable.usermenu)));
            items.add(new NavigationItem("التقويم الدراسى", getResources().getDrawable(R.drawable.calendarmenu)));
            items.add(new NavigationItem("الساعة الذكية", getResources().getDrawable(R.drawable.watch)));
            items.add(new NavigationItem("معرض الصور", getResources().getDrawable(R.drawable.gallery2)));
            items.add(new NavigationItem("غرفة المحادثة", getResources().getDrawable(R.drawable.chat)));
            items.add(new NavigationItem("المساعدة", getResources().getDrawable(R.drawable.help)));
            items.add(new NavigationItem("عن التطبيق", getResources().getDrawable(R.drawable.about)));
            items.add(new NavigationItem("الاعدادات", getResources().getDrawable(R.drawable.setting)));
            items.add(new NavigationItem("قيمنا", getResources().getDrawable(R.drawable.rate)));
            items.add(new NavigationItem("مشاركة التطبيق", getResources().getDrawable(R.drawable.sharenew)));
            items.add(new NavigationItem("تسجيل الخروج", getResources().getDrawable(R.drawable.logout)));
        }else
            {
                items.add(new NavigationItem("Account", getResources().getDrawable(R.drawable.usermenu)));
                items.add(new NavigationItem("Calendar", getResources().getDrawable(R.drawable.calendarmenu)));
                items.add(new NavigationItem("Smart Watch", getResources().getDrawable(R.drawable.watch)));
                items.add(new NavigationItem("Gallery", getResources().getDrawable(R.drawable.gallery2)));
                items.add(new NavigationItem("Chat Room", getResources().getDrawable(R.drawable.chat)));
                items.add(new NavigationItem("Help", getResources().getDrawable(R.drawable.help)));
                items.add(new NavigationItem("About", getResources().getDrawable(R.drawable.about)));
                items.add(new NavigationItem("Setting", getResources().getDrawable(R.drawable.setting)));
                items.add(new NavigationItem("Rate Us", getResources().getDrawable(R.drawable.rate)));
                items.add(new NavigationItem("Share Application", getResources().getDrawable(R.drawable.sharenew)));
                items.add(new NavigationItem("Logout", getResources().getDrawable(R.drawable.logout)));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(language==1)
        {
            studentname.setText(sp.getSelectedItem().toString()+" جمال الدين");
        }else
            {
                studentname.setText(sp.getSelectedItem().toString()+" Gamal Eldeen");
            }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
