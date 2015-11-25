package br.com.fiap.carroapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.fiap.carroapp.adapter.TabsAdapter;

public class MainActivity extends AppCompatActivity {

    //Utilizar sempre a Toolbar oriunda da lib de suporte
    private Toolbar toolbarMain;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.toolbar_mainID);

        //Substitui a ActionBar padrao pela Toolbar criada (modelo novo)
        setSupportActionBar(toolbarMain);

        tabLayout = (TabLayout) findViewById(R.id.tabsID);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lbl_tab_classicos));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lbl_tab_esportivos));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lbl_tab_luxuosos));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.viewPagerID);

        //Utiliza-se o adapter para fazer com que a cada click em uma tab, o viewPager tambem seja alterado para acompanhar a mudanca da tab
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id) {
            case R.id.mn_cadastrar:
                Toast.makeText(this, "Menu Cadastrar Acionado!", Toast.LENGTH_LONG).show();
                break;

            case R.id.mn_configuracao:
                Toast.makeText(this, "Menu Configuração Acionado!", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
