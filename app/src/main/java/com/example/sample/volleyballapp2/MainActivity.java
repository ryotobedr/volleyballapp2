package com.example.sample.volleyballapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // タイトルを設定
        toolbar.setTitle("スパイク・ブロック");

        // ナビゲーションアイコンの設定、クリック処理
//        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ナビゲーションアイコンクリック時の処理
            }
        });

        // メニューのインフレート、メニューアイテムのクリック処理
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // メニューのクリック処理
                return true;
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter.add("1");
        adapter.add("2");
        adapter.add("3");
        adapter.add("4");
        adapter.add("5");
        adapter.add("6");
        adapter.add("7");
        adapter.add("8");
        adapter.add("9");
        adapter.add("10");
        adapter.add("11");
        adapter.add("12");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // アダプターを設定します
        spinner.setAdapter(adapter);
        // スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得します
                String item = (String) spinner.getSelectedItem();
                //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // GridLayout内のアイテムをレイアウトサイズに合わせてストレッチ
        final GridLayout gl = (GridLayout) findViewById(R.id.SpBlKiroku);
        int childWidth = gl.getWidth() / gl.getColumnCount();
//        int childHeight = gl.getHeight() / gl.getRowCount();
        for (int i = 0; i < gl.getChildCount(); i++) {
           gl.getChildAt(i).setMinimumWidth(childWidth);
//           gl.getChildAt(i).setMinimumHeight(childHeight);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Clear ボタン
    public void Clear(View v){

    }

    // Name1 スパイク 〇 ＋ボタン
    public void SpPlusMaru1(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spmaruint++;
        spmaru.setText(spmaruint+"");
        sphonsuint++;
        sphonsu.setText(sphonsuint+"");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu+"%");
    }

    // Name1 スパイク 〇 ーボタン
    public void SpMinusMaru1(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int spmaruint = Integer.parseInt(spmarustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        long ketteiritu;

        if (spmaruint>0){
            spmaruint--;
            spmaru.setText(spmaruint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name1 スパイク △ ＋ボタン
    public void SpPlusSankaku1(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spsankakuint = Integer.parseInt(spsankakustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spsankakuint++;
        spsankaku.setText(spsankakuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");
//        Log.d("spmaruint", spmaruint + "");
//        Log.d("ketteiritu", Math.round(spmaruint * 100.0 / sphonsuint) + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    //Name1 スパイク △ ーボタン
    public void SpMinusSankaku1(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int spsankakuint = Integer.parseInt(spsankakustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spsankakuint>0){
            spsankakuint--;
            spsankaku.setText(spsankakuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name1 スパイク × ＋ボタン
    public void SpPlusBatu1(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spbatuint = Integer.parseInt(spbatustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spbatuint++;
        spbatu.setText(spbatuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name1 スパイク × ーボタン
    public void SpMinusBatu1(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu1);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu1);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu1);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru1);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int spbatuint = Integer.parseInt(spbatustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spbatuint>0){
            spbatuint--;
            spbatu.setText(spbatuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name1 ブロック 本数 ＋ボタン
    public void BlPlusHon1(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon1);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView blketteiritu = (TextView) findViewById(R.id.Blritu1);
        double tmp;
        double ketteiritu;

        String blhonsustr = (String) blhonsu.getText();
        String spinnerstr = (String) spinner.getSelectedItem();

        int blhosuint = Integer.parseInt(blhonsustr);
        int spinnerint = Integer.parseInt(spinnerstr);

        blhosuint++;
        blhonsu.setText(blhosuint + "");

        tmp = blhosuint * 1.0 / spinnerint * 1.0;

        BigDecimal bi = new BigDecimal(String.valueOf(tmp));

        ketteiritu = bi.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        blketteiritu.setText(ketteiritu + "%");
    }

    // Name1 ブロック 本数 ーボタン
    public void BlMinusHon1(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon1);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView blketteiritu = (TextView) findViewById(R.id.Blritu1);
        double tmp;
        double ketteiritu;

        String blhonsustr = (String) blhonsu.getText();
        String spinnerstr = (String) spinner.getSelectedItem();

        int blhosuint = Integer.parseInt(blhonsustr);
        int spinnerint = Integer.parseInt(spinnerstr);

        if (blhosuint>0){
            blhosuint--;
            blhonsu.setText(blhosuint + "");
        }

        tmp = blhosuint * 1.0 / spinnerint * 1.0;

        BigDecimal bi = new BigDecimal(String.valueOf(tmp));
        ketteiritu = bi.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        blketteiritu.setText(ketteiritu + "%");
    }

    // Name2 スパイク 〇 ＋ボタン
    public void SpPlusMaru2(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spmaruint++;
        spmaru.setText(spmaruint+"");
        sphonsuint++;
        sphonsu.setText(sphonsuint+"");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu+"%");
    }

    // Name2 スパイク 〇 ーボタン
    public void SpMinusMaru2(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int spmaruint = Integer.parseInt(spmarustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        long ketteiritu;

        if (spmaruint>0){
            spmaruint--;
            spmaru.setText(spmaruint+"");
            sphonsuint--;
            sphonsu.setText(sphonsuint+"");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name2 スパイク △ ＋ボタン
    public void SpPlusSankaku2(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spsankakuint = Integer.parseInt(spsankakustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spsankakuint++;
        spsankaku.setText(spsankakuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");
//        Log.d("spmaruint", spmaruint + "");
//        Log.d("ketteiritu", Math.round(spmaruint * 100.0 / sphonsuint) + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    //Name2 スパイク △ ーボタン
    public void SpMinusSankaku2(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int spsankakuint = Integer.parseInt(spsankakustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spsankakuint>0){
            spsankakuint--;
            spsankaku.setText(spsankakuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name2 スパイク × ＋ボタン
    public void SpPlusBatu2(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spbatuint = Integer.parseInt(spbatustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spbatuint++;
        spbatu.setText(spbatuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name2 スパイク × ーボタン
    public void SpMinusBatu2(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu2);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu2);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu2);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru2);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int spbatuint = Integer.parseInt(spbatustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spbatuint>0){
            spbatuint--;
            spbatu.setText(spbatuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name2 ブロック 本数 ＋ボタン
    public void BlPlusHon2(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon2);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        blhosuint++;
        blhonsu.setText(blhosuint+"");
     }

    // Name2 ブロック 本数 ーボタン
    public void BlMinusHon2(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon2);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        if(blhosuint>0){
            blhosuint--;
            blhonsu.setText(blhosuint + "");
        }
    }

    // Name3 スパイク 〇 ＋ボタン
    public void SpPlusMaru3(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spmaruint++;
        spmaru.setText(spmaruint+"");
        sphonsuint++;
        sphonsu.setText(sphonsuint+"");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu+"%");
    }

    // Name3 スパイク 〇 ーボタン
    public void SpMinusMaru3(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int spmaruint = Integer.parseInt(spmarustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        long ketteiritu;

        if (spmaruint>0){
            spmaruint--;
            spmaru.setText(spmaruint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name3 スパイク △ ＋ボタン
    public void SpPlusSankaku3(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spsankakuint = Integer.parseInt(spsankakustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spsankakuint++;
        spsankaku.setText(spsankakuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");
//        Log.d("spmaruint", spmaruint + "");
//        Log.d("ketteiritu", Math.round(spmaruint * 100.0 / sphonsuint) + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    //Name3 スパイク △ ーボタン
    public void SpMinusSankaku3(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int spsankakuint = Integer.parseInt(spsankakustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spsankakuint>0){
            spsankakuint--;
            spsankaku.setText(spsankakuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }


    // Name3 スパイク × ＋ボタン
    public void SpPlusBatu3(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spbatuint = Integer.parseInt(spbatustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spbatuint++;
        spbatu.setText(spbatuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name3 スパイク × ーボタン
    public void SpMinusBatu3(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu3);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu3);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu3);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru3);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int spbatuint = Integer.parseInt(spbatustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spbatuint>0){
            spbatuint--;
            spbatu.setText(spbatuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name3 ブロック 本数 ＋ボタン
    public void BlPlusHon3(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon3);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        blhosuint++;
        blhonsu.setText(blhosuint+"");
    }

    // Name3 ブロック 本数 ーボタン
    public void BlMinusHon3(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon3);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        if(blhosuint>0){
            blhosuint--;
            blhonsu.setText(blhosuint + "");
        }
    }

    // Name4 スパイク 〇 ＋ボタン
    public void SpPlusMaru4(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spmaruint++;
        spmaru.setText(spmaruint+"");
        sphonsuint++;
        sphonsu.setText(sphonsuint+"");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu+"%");
    }

    // Name4 スパイク 〇 ーボタン
    public void SpMinusMaru4(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int spmaruint = Integer.parseInt(spmarustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        long ketteiritu;

        if (spmaruint>0){
            spmaruint--;
            spmaru.setText(spmaruint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 スパイク △ ＋ボタン
    public void SpPlusSankaku4(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spsankakuint = Integer.parseInt(spsankakustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spsankakuint++;
        spsankaku.setText(spsankakuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");
//        Log.d("spmaruint", spmaruint + "");
//        Log.d("ketteiritu", Math.round(spmaruint * 100.0 / sphonsuint) + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    //Name4 スパイク △ ーボタン
    public void SpMinusSankaku4(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int spsankakuint = Integer.parseInt(spsankakustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spsankakuint>0){
            spsankakuint--;
            spsankaku.setText(spsankakuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 スパイク × ＋ボタン
    public void SpPlusBatu4(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spbatuint = Integer.parseInt(spbatustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spbatuint++;
        spbatu.setText(spbatuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 スパイク × ーボタン
    public void SpMinusBatu4(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu4);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu4);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu4);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru4);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int spbatuint = Integer.parseInt(spbatustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spbatuint>0){
            spbatuint--;
            spbatu.setText(spbatuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 ブロック 本数 ＋ボタン
    public void BlPlusHon4(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon4);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        blhosuint++;
        blhonsu.setText(blhosuint+"");
    }

    // Name4 ブロック 本数 ーボタン
    public void BlMinusHon4(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon4);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        if(blhosuint>0){
            blhosuint--;
            blhonsu.setText(blhosuint + "");
        }
    }

    // Name4 スパイク 〇 ＋ボタン
    public void SpPlusMaru5(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spmaruint++;
        spmaru.setText(spmaruint+"");
        sphonsuint++;
        sphonsu.setText(sphonsuint+"");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu+"%");
    }

    // Name4 スパイク 〇 ーボタン
    public void SpMinusMaru5(View v) {
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);

        String sphonsustr = (String) sphonsu.getText();
        String spmarustr = (String) spmaru.getText();

        int spmaruint = Integer.parseInt(spmarustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        long ketteiritu;

        if (spmaruint>0){
            spmaruint--;
            spmaru.setText(spmaruint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 スパイク △ ＋ボタン
    public void SpPlusSankaku5(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spsankakuint = Integer.parseInt(spsankakustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spsankakuint++;
        spsankaku.setText(spsankakuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");
//        Log.d("spmaruint", spmaruint + "");
//        Log.d("ketteiritu", Math.round(spmaruint * 100.0 / sphonsuint) + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    //Name4 スパイク △ ーボタン
    public void SpMinusSankaku5(View v) {
        TextView spsankaku = (TextView) findViewById(R.id.SpSankaku5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);

        String sphonsustr = (String) sphonsu.getText();
        String spsankakustr = (String) spsankaku.getText();
        String spmarustr = (String) spmaru.getText();

        int spsankakuint = Integer.parseInt(spsankakustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spsankakuint>0){
            spsankakuint--;
            spsankaku.setText(spsankakuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }


    // Name4 スパイク × ＋ボタン
    public void SpPlusBatu5(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int sphonsuint = Integer.parseInt(sphonsustr);
        int spbatuint = Integer.parseInt(spbatustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        spbatuint++;
        spbatu.setText(spbatuint + "");
        sphonsuint++;
        sphonsu.setText(sphonsuint + "");

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 スパイク × ーボタン
    public void SpMinusBatu5(View v) {
        TextView spbatu = (TextView) findViewById(R.id.SpBatu5);
        TextView sphonsu = (TextView) findViewById(R.id.SpHonsu5);
        TextView spketteiritu = (TextView) findViewById(R.id.SpKetteiritu5);
        TextView spmaru = (TextView) findViewById(R.id.SpMaru5);

        String sphonsustr = (String) sphonsu.getText();
        String spbatustr = (String) spbatu.getText();
        String spmarustr = (String) spmaru.getText();

        int spbatuint = Integer.parseInt(spbatustr);
        int sphonsuint = Integer.parseInt(sphonsustr);
        int spmaruint = Integer.parseInt(spmarustr);
        long ketteiritu;

        if (spbatuint>0){
            spbatuint--;
            spbatu.setText(spbatuint + "");
            sphonsuint--;
            sphonsu.setText(sphonsuint + "");
        }

        ketteiritu = Math.round(spmaruint * 100.0 / sphonsuint);
        spketteiritu.setText(ketteiritu + "%");
    }

    // Name4 ブロック 本数 ＋ボタン
    public void BlPlusHon5(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon5);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        blhosuint++;
        blhonsu.setText(blhosuint+"");
    }

    // Name4 ブロック 本数 ーボタン
    public void BlMinusHon5(View v){
        TextView blhonsu = (TextView) findViewById(R.id.BlHon5);

        String blhonsustr = (String) blhonsu.getText();

        int blhosuint = Integer.parseInt(blhonsustr);

        if(blhosuint>0){
            blhosuint--;
            blhonsu.setText(blhosuint + "");
        }
    }


}
