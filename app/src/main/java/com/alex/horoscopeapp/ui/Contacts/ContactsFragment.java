package com.alex.horoscopeapp.ui.Contacts;

import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alex.horoscopeapp.R;

public class ContactsFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        TextView textViewLinkGmail = root.findViewById(R.id.textViewLinkGmail);
        TextView textViewLinkTelegram = root.findViewById(R.id.textViewLinkTelegram);
        String textWithLinkGmail = "<a href=\"mailto:shumilovsash@gmail.com\">Gmail</a>";
        String textWithLinkTelegram = "<a href=\"https://t.me/EveryLuvSugar\">Telegram</a>";

//Указываем с помощью Html.fromHtml, что у нас не просто текст:
        textViewLinkGmail.setText(Html.fromHtml(textWithLinkGmail, null, null));
        textViewLinkTelegram.setText(Html.fromHtml(textWithLinkTelegram, null, null));
////Указываем что разрешаем ссылки кликать:
        textViewLinkGmail.setLinksClickable(true);
        textViewLinkGmail.setMovementMethod(LinkMovementMethod.getInstance());
        textViewLinkTelegram.setLinksClickable(true);
        textViewLinkTelegram.setMovementMethod(LinkMovementMethod.getInstance());
//Научаемся отлавливать клики пропустив текст через наш класс из пред. пункта.
        CharSequence textGmail = textViewLinkGmail.getText();
        CharSequence textTelegram = textViewLinkTelegram.getText();
        if (textGmail instanceof Spannable)
        {
            textViewLinkGmail.setText(MakeLinksClicable.reformatText(textGmail));
        }else if (textTelegram instanceof Spannable){
            textViewLinkTelegram.setText(MakeLinksClicable.reformatText(textTelegram));
        }

        return root;
    }
}