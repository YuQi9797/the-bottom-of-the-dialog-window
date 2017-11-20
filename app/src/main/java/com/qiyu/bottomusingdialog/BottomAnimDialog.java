package com.qiyu.bottomusingdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by asus on 2017/11/19.
 */

public class BottomAnimDialog extends Dialog implements View.OnClickListener {

    private TextView photoText;

    private TextView photographText;

    private TextView cancelText;

    private BottomAnimDialogListener listener;


    public interface BottomAnimDialogListener {
        public void onClick(View view);
    }


    public BottomAnimDialog(@NonNull Context context,BottomAnimDialogListener listener) {
        //构造方法中，传入主题
        super(context, R.style.BottomAnimDialogStyle);
        this.listener = listener;

        //拿到Dialog的Window，修改Window的属性
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获取Window的LayoutParams
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        //一定要重新设置，才能生效
        window.setAttributes(attributes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_anim_dialog_layout);
        initViews();
    }

    private void initViews() {
        photoText = (TextView) findViewById(R.id.tv_photo);
        photographText = (TextView) findViewById(R.id.tv_photograph);
        cancelText = (TextView) findViewById(R.id.tv_cancle);

        photoText.setOnClickListener(this);
        photographText.setOnClickListener(this);
        cancelText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }

}
