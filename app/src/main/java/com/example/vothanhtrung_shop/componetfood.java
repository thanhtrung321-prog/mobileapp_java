package com.example.vothanhtrung_shop;

import android.text.Html;
import android.widget.TextView;

public class componetfood {
    private TextView textView;

    // Constructor nhận TextView
    public componetfood(TextView textView) {
        this.textView = textView;
    }

    // Phương thức Oncreated
    public void Oncreated() {
        String htmlText = "<ul>" +
                "<li>Noddle</li>" +
                "<li>Salad</li>" +
                "<li>Burger</li>" +
                "<li>Herbal Pan Cake</li>" +
                "<li>Momos</li>" +
                "</ul>";
        textView.setText(Html.fromHtml(htmlText));
    }
}
