package com.bw.text;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        setText();
    }

    private void setText() {
        SpannableString word = new SpannableString("迭代是最好的老师！");
        word.setSpan(new BackgroundColorSpan(Color.GREEN), 0, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);
        //ClickableSpan 文本可点击，有点击事件
        word = new SpannableString("每天进步一点点- http://orgcent.com");
        word.setSpan(new ForegroundColorSpan(Color.BLUE), 6, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);

        SpannableString str = new SpannableString("1232131232");
        str.setSpan(new StrikethroughSpan(),0,str.length(),Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv1.setText(str);

        SpannableString strr = new SpannableString("迭代是最好的老师！");
        word.setSpan(new ForegroundColorSpan(Color.GREEN), 0, strr.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv2.setText(strr);

        SpannableString spanText = new SpannableString("MaskFilterSpan -- http://orgcent.com");
        int length = spanText.length();
        //模糊(BlurMaskFilter)
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        spanText.setSpan(maskFilterSpan, 0, length - 10, Spannable.
                SPAN_INCLUSIVE_EXCLUSIVE);
        //浮雕(EmbossMaskFilter)
        maskFilterSpan = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1,1,3}, 1.5f, 8, 3));
        spanText.setSpan(maskFilterSpan, length - 10, length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv3.append("\n");
        tv3.append(spanText);
    }
}
