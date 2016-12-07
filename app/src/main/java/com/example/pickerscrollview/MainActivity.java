package com.example.pickerscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pickerscrollview.bean.Pickers;
import com.example.pickerscrollview.PickerScrollView.onSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bt_scrollchoose; // ����ѡ������ť
    private List<Pickers> list; // ����ѡ��������
    private String[] id;
    private String[] name;
    private PickerScrollView pickerscrlllview;
    private Button bt_yes; // ȷ����ť
    private RelativeLayout picker_rel; // ѡ��������
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initLinstener();
        initData();
    }

    /**
     * ��ʼ��
     */
    private void initView() {
        bt_scrollchoose = (Button) findViewById(R.id.bt_scrollchoose);
        picker_rel = (RelativeLayout) findViewById(R.id.picker_rel);
        pickerscrlllview = (PickerScrollView) findViewById(R.id.pickerscrlllview);
        bt_yes = (Button) findViewById(R.id.picker_yes);
        mTextView= (TextView) findViewById(R.id.text);
    }

    /**
     * ���ü����¼�
     */
    private void initLinstener() {
        bt_scrollchoose.setOnClickListener(onClickListener);
        pickerscrlllview.setOnSelectListener(pickerListener);
        bt_yes.setOnClickListener(onClickListener);
    }

    /**
     * ��ʼ������
     */
    private void initData() {
        list = new ArrayList<Pickers>();
        id = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        name = new String[]{"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        for (int i = 0; i < name.length; i++) {
            list.add(new Pickers(name[i], id[i]));
        }
        // �������ݣ�Ĭ��ѡ���һ��
        pickerscrlllview.setData(list);
        pickerscrlllview.setSelected(0);
    }

    // ����ѡ����ѡ���¼�
    onSelectListener pickerListener = new onSelectListener() {

        @Override
        public void onSelect(Pickers pickers) {

            Toast.makeText(MainActivity.this, "11111" + pickers.getShowConetnt(), Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "2222" + pickers.getShowId(), Toast.LENGTH_SHORT).show();

            mTextView.setText(pickers.getShowConetnt());

        }
    };

    // ��������¼�
    OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == bt_scrollchoose) {
                picker_rel.setVisibility(View.VISIBLE);
            } else if (v == bt_yes) {
                picker_rel.setVisibility(View.GONE);
            }
        }
    };
}
