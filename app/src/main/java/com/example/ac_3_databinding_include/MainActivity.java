package com.example.ac_3_databinding_include;
//0.寫好Student類別
//參考網址:https://blog.csdn.net/kong_gu_you_lan/article/details/75628465
/**
 *
 //1.引用類別包
 <data>
 <import type="android.view.View"/> //引用類別包
 </data>

 //2.可以做邏輯判斷:
 //如果學生年紀大於18怎Text顯示,反之隱藏
 android:text="@{student.name}"
 android:visibility="@{student.age >= 18? View.VISIBLE : View.GONE}"

 //3.當imprant的類別名稱衝突時可以另外命名:
 <import type="android.view.View"(要導入的包) alias(別名)="HaView" />
 因為改變了包的類別名稱,所以要改成以下
 android:visibility="@{student.age >= 18? HaView.VISIBLE : HaView.GONE}"


 // 4.可以宣告多個變數.並將導入的類別自訂為自己的變數,物件實體化來玩
 <import type="android.graphics.Color"/> //導入包
 <variable name="color" type="Color" />  //name ="變數名" type="要引用的類別名稱"
 <variable name="note" type="String" />

 //5.DataBinding_include別的頁面
 5.1要先在主Layout加入 xmlns:bind="http://schemas.android.com/apk/res-auto"
 layout
 xmlns:bind="http://schemas.android.com/apk/res-auto"


 5.2include別的頁面
 layout="@layout/conte_b" bind:student="@{student}" /> //bind:(自訂名) ="綁定的類別"
 -->

 //6.
 要被include的Layout一樣配置你要玩的Data綁定,跟Layout
 這邊完年紀年紀是int轉型為String
 android:text="@{String.valueOf(student.age)}"


 */


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;

import com.example.ac_3_databinding_include.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Student student = new Student("齊天大聖","孫悟空",18);
        activityMainBinding.setStudent(student);

    }
}
