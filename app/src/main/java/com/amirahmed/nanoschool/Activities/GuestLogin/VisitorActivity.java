package com.amirahmed.nanoschool.Activities.GuestLogin;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.HelpActivity;
import com.amirahmed.nanoschool.Activities.NewAboutApplicationActivity;
import com.amirahmed.nanoschool.Activities.SchoolCalenderActivity;
import com.amirahmed.nanoschool.Activities.SettingActivity;
import com.amirahmed.nanoschool.Adapters.GuestLogin.CultureAdapter;
import com.amirahmed.nanoschool.Adapters.GuestLogin.NewsAdapter;
import com.amirahmed.nanoschool.Adapters.GuestLogin.SchoolsListAdapter;
import com.amirahmed.nanoschool.Fragments.FilterFragment;
import com.amirahmed.nanoschool.Fragments.NavigationDrawerGuestFragment;
import com.amirahmed.nanoschool.Models.GuestLogin.CultureItem;
import com.amirahmed.nanoschool.Models.GuestLogin.NewsItem;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.NavigationDrawerCallbacks;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.codemybrainsout.ratingdialog.RatingDialog;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VisitorActivity extends AppCompatActivity implements NavigationDrawerCallbacks,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,SearchView.OnQueryTextListener {

    private SliderLayout mDemoSlider;
    private NavigationDrawerGuestFragment mNavigationDrawerFragment;
    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    DrawerLayout drawerLayout;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2,rv3,rv4;

    private List<NewsItem> newsItems;
    private List<CultureItem> cultureItems;

    SchoolsListAdapter adapter;

    ImageView culture,news,allschools;

    ImageView filter;

    SearchView searchView;

    RelativeLayout sliderlayout;

    LinearLayout bottommenu,newslayout,infolayout,schoolslayout;

    TextView allschoolstext,newstext,culturetext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);

        drawerLayout = findViewById(R.id.drawer);

        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);

        bottommenu = findViewById(R.id.bottommenu);
        newslayout = findViewById(R.id.newslayout);
        infolayout = findViewById(R.id.infolayout);
        schoolslayout = findViewById(R.id.schoolslayout);
        allschoolstext = findViewById(R.id.allschoolstext);
        newstext = findViewById(R.id.newstext);
        culturetext = findViewById(R.id.culturetext);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            drawerLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            searchView = mToolbar.findViewById(R.id.searchView);
            searchView.setOnQueryTextListener(this);

            filter = mToolbar.findViewById(R.id.filter);

        }else
        {
            mToolbar.setVisibility(View.GONE);
            mToolbar2.setVisibility(View.VISIBLE);

            drawerLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            searchView = mToolbar2.findViewById(R.id.searchView);
            searchView.setOnQueryTextListener(this);

            filter = mToolbar2.findViewById(R.id.filter);

            bottommenu.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            allschoolstext.setText("Schools");
            newstext.setText("News");
            culturetext.setText("Info");
        }

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentManager fm = getFragmentManager();
                FilterFragment filterFragment = new FilterFragment();

                filterFragment.show(fm,"TV_tag");
            }
        });

        sliderlayout = findViewById(R.id.sliderlayout);

        mDemoSlider = findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Banner 1", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523623875/WhatsApp_Image_2018-04-13_at_10.13.26_AM.jpg");
        url_maps.put("Banner 2", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624016/WhatsApp_Image_2018-04-13_at_10.13.26_AM-2.jpg");
        url_maps.put("Banner 3", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624029/WhatsApp_Image_2018-04-13_at_10.13.26_AM-3.jpg");
        url_maps.put("Banner 4", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624041/WhatsApp_Image_2018-04-13_at_10.13.27_AM.jpg");
        url_maps.put("Banner 5", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624058/WhatsApp_Image_2018-04-13_at_10.13.27_AM-2.jpg");


        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("School-1",R.drawable.school);
        file_maps.put("School-2",R.drawable.school2);
        file_maps.put("School-3",R.drawable.school3);
        file_maps.put("School-4",R.drawable.school4);
        file_maps.put("School-5",R.drawable.school5);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        rv2 = findViewById(R.id.schools_recycler_view);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        allschools = findViewById(R.id.messages);

        culture = findViewById(R.id.messages2);

        news = findViewById(R.id.messages3);

        schoolslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sliderlayout.setVisibility(View.VISIBLE);
                rv2.setVisibility(View.VISIBLE);
                rv3.setVisibility(View.GONE);
                rv4.setVisibility(View.GONE);

                searchView.setVisibility(View.VISIBLE);
                filter.setVisibility(View.VISIBLE);

            }
        });

        newslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sliderlayout.setVisibility(View.GONE);
                rv2.setVisibility(View.GONE);
                rv3.setVisibility(View.VISIBLE);
                rv4.setVisibility(View.GONE);

                searchView.setVisibility(View.INVISIBLE);
                filter.setVisibility(View.INVISIBLE);

            }
        });

        infolayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sliderlayout.setVisibility(View.GONE);
                rv2.setVisibility(View.GONE);
                rv3.setVisibility(View.GONE);
                rv4.setVisibility(View.VISIBLE);

                searchView.setVisibility(View.INVISIBLE);
                filter.setVisibility(View.INVISIBLE);
            }
        });

        mNavigationDrawerFragment = (NavigationDrawerGuestFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);



        // Set up the drawer.
        if(language==1)
        {
            mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        }else
        {
            mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar2);
        }


        setupnews();
        setupculture();


    }

    public void setupnews()
    {
        rv3 = findViewById(R.id.news_rv);

        rv3.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv3.setLayoutManager(llm);

        initializeData2();
        initializeAdapter2();
    }

    public void setupculture()
    {
        rv4 = findViewById(R.id.culture_rv);

        rv4.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv4.setLayoutManager(llm);

        initializeData3();
        initializeAdapter3();
    }


    private void initializeData2() {
        newsItems = new ArrayList<>();

        if (language == 1) {

            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));
            newsItems.add(new NewsItem("المشاركة فى اليوم العالمى للطفل","المشاركة فى اليوم العالمى للطفل","اكتوبر ٢٠١٤"));

        } else {

            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
            newsItems.add(new NewsItem("Kids international day sharing","Kids international day sharing","October 2014"));
        }
    }

    private void initializeAdapter2() {

        NewsAdapter adapter = new NewsAdapter(newsItems);
        rv3.setAdapter(adapter);

    }

    private void initializeData3() {
        cultureItems = new ArrayList<>();

        if (language == 1) {

            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));



        } else {

            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
        }
    }

    private void initializeAdapter3() {

        CultureAdapter adapter = new CultureAdapter(cultureItems);
        rv4.setAdapter(adapter);

    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {

        if(position==0)
        {
            Intent intent = new Intent(VisitorActivity.this , SchoolCalenderActivity.class);
            startActivity(intent);
        }else if (position==1)
        {
            Intent intent = new Intent(VisitorActivity.this , ComparisionActivity.class);
            startActivity(intent);
        }else if (position==2)
        {
            Intent intent = new Intent(VisitorActivity.this , NewAboutApplicationActivity.class);
            startActivity(intent);
        }else if (position==3)
        {
            Intent intent = new Intent(VisitorActivity.this , HelpActivity.class);
            startActivity(intent);
        }else if (position==4)
        {
            Intent intent = new Intent(VisitorActivity.this , SettingActivity.class);
            startActivity(intent);

            tinyDB.putString("Setting","Guest");

        }else if (position==5)
        {
            Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT, "Share App Link");
            startActivity(Intent.createChooser(intent2, "Share via"));
        }else if (position==6)
        {
            rateApp();
        }
    }

    public void rateApp()
    {
        if(language==1)
        {
            final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                    .icon(getDrawable(R.drawable.stars))
                    .threshold(3)
                    .title("كيف هى تجربتك معنا ؟")
                    .titleTextColor(R.color.black)
                    .positiveButtonText("ليس الأن")
                    .negativeButtonText("أبدا")
                    .positiveButtonTextColor(R.color.myPrimaryColor)
                    .negativeButtonTextColor(R.color.myPrimaryColor)
                    .formTitle("أرسل رأيك")
                    .formHint("أخبرنا كيف نقوم بتحسين خدماتنا")
                    .formSubmitText("حفظ")
                    .formCancelText("ألغاء")
                    .ratingBarColor(R.color.myPrimaryColor)
                    .playstoreUrl("")
                    .onThresholdCleared(new RatingDialog.Builder.RatingThresholdClearedListener() {
                        @Override
                        public void onThresholdCleared(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onThresholdFailed(new RatingDialog.Builder.RatingThresholdFailedListener() {
                        @Override
                        public void onThresholdFailed(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                        @Override
                        public void onRatingSelected(float rating, boolean thresholdCleared) {

                        }
                    })
                    .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                        @Override
                        public void onFormSubmitted(String feedback) {

                        }
                    }).build();

            ratingDialog.show();
        }else
            {
                final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                        .icon(getDrawable(R.drawable.stars))
                        .threshold(3)
                        .title("How was your experience with us?")
                        .titleTextColor(R.color.black)
                        .positiveButtonText("Not Now")
                        .negativeButtonText("Never")
                        .positiveButtonTextColor(R.color.myPrimaryColor)
                        .negativeButtonTextColor(R.color.myPrimaryColor)
                        .formTitle("Submit Feedback")
                        .formHint("Tell us where we can improve")
                        .formSubmitText("Submit")
                        .formCancelText("Cancel")
                        .ratingBarColor(R.color.myPrimaryColor)
                        .playstoreUrl("")
                        .onThresholdCleared(new RatingDialog.Builder.RatingThresholdClearedListener() {
                            @Override
                            public void onThresholdCleared(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                                //do something
                                ratingDialog.dismiss();
                            }
                        })
                        .onThresholdFailed(new RatingDialog.Builder.RatingThresholdFailedListener() {
                            @Override
                            public void onThresholdFailed(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                                //do something
                                ratingDialog.dismiss();
                            }
                        })
                        .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                            @Override
                            public void onRatingSelected(float rating, boolean thresholdCleared) {

                            }
                        })
                        .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                            @Override
                            public void onFormSubmitted(String feedback) {

                            }
                        }).build();

                ratingDialog.show();
            }



    }

    private void initializeData() {
        schoolsListItems = new ArrayList<>();

        if(language==1)
        {
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","دولية | جميع المراحل"));
        }else
            {
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
                schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
            }


    }

    private void initializeAdapter() {

        adapter = new SchoolsListAdapter(schoolsListItems);
        adapter.setFilter(schoolsListItems);
        rv2.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {

            getMenuInflater().inflate(R.menu.guest, menu);

            final MenuItem item = menu.findItem(R.id.action_search);
            final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            searchView.setOnQueryTextListener(this);

            MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    // Do something when collapsed
                    adapter.setFilter(schoolsListItems);
                    return true; // Return true to collapse action view
                }

                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    // Do something when expanded
                    return true; // Return true to expand action view
                }
            });

        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<SchoolsListItem> filteredModelList = filter(schoolsListItems, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    private List<SchoolsListItem> filter(List<SchoolsListItem> models, String query) {
        query = query.toLowerCase();

        final List<SchoolsListItem> filteredModelList = new ArrayList<>();
        for (SchoolsListItem model : models) {
            final String text = model.getSchoolName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
