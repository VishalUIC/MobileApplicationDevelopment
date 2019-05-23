package edu.vishal.cs478.gridviewproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by visha on 10/6/2017.
 */

public class ContextMenuCarDealer extends ListActivity {
    String [] acura={"McGrath Acura of Downtown Chicago \n 1301 N Elston Ave, Chicago, IL 60642","Greater Chicago Motors \n 1850 N Elston Ave, Chicago, IL 60642","West End Auto Inc \n 148 N Cicero Ave, Chicago, IL 60644"};
    String [] audi={"Audi Westmont \n 276 E Ogden Ave, Westmont, IL 60559","Audi Orland Park Parts Department \n 8021 W 159th St, Tinley Park, IL 60477","Fletcher Jones Audi \n 1523 W North Ave, Chicago, IL 60642"};
    String [] civic={"Windy City Motors \n 2662 N Cicero Ave, Chicago, IL 60639", "CarMax \n 6540 95th St, Oak Lawn, IL 60453", "Fletcher Jones Honda Parts \n 1100 N Clark St, Chicago, IL 60610"};
    String [] porsche={"Windy City Motors \n 2662 N Cicero Ave, Chicago, IL 60639", "Bavarian Motors \n 27 N May St, Chicago, IL 60607", "Loeber Porsche \n 7101 Lincoln Ave, Lincolnwood, IL 60712"};
    String [] mercedes={"Mercedes-Benz of Chicago \n 1520 W North Ave, Chicago, IL 60642", "Windy City Motors \n 2662 N Cicero Ave, Chicago, IL 60639", "Mercedes-Benz of Chicago Service Center \n 949 N Elston Ave #2, Chicago, IL 60642"};
    String [] camry={"Continental Toyota \n 6701 South La Grange Road, Hodgkins, IL 60525", "CarMax \n 6540 95th St, Oak Lawn, IL 60453", "Grossinger City Toyota \n 1561 N Fremont St, Chicago, IL 60642"};
    String [] lexus={"Bredemann Lexus \n 2000 Waukegan Rd, Glenview, IL 60025", "Jidd Motors European Imports \n 1313 Rand Rd, Des Plaines, IL 60016", "McGrath Lexus of Chicago \n 1250 W Division St, Chicago, IL 60642"};
    String [] chevrolet={"Currie Motors Chevrolet \n 8401 W Roosevelt Rd, Forest Park, IL 60130", "Rogers Chevrolet \n 2720 S Michigan Ave, Chicago, IL 60616", "Kingdom Chevy \n 6603 S Western Ave, Chicago, IL 60636"};
    String [] jaguar={"Jaguar Elmhurst \n 490 W Lake St, Elmhurst, IL 60126", "Jaguar of Naperville \n 1559 West Ogden Avenue, Suite B, Naperville, IL 60540", "Howard Orloff Jaguar \n 1924 N Paulina St, Chicago, IL 60622"};

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        //setContentView(R.layout.activity_context_menu_car_dealer);
        ListView listView;
        Intent intent = getIntent();
        int pos1 = intent.getIntExtra("position",0);
        //Switch the dealers based on the image of the car clicked
        switch (pos1) {
            case 0:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,acura));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 1:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,audi));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 2:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,civic));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 3:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,porsche));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 4:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,mercedes));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 5:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,camry));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 6:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,lexus));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 7:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,chevrolet));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
            case 8:
                setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_context_menu_car_dealer,jaguar));
                listView = getListView();
                listView.setTextFilterEnabled(true);
                break;
        }

    }
}
