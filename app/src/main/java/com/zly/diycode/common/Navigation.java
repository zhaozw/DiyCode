package com.zly.diycode.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zly.diycode.reply.AddReplyActivity;
import com.zly.diycode.topics.TopicsDetailActivity;
import com.zly.diycode.web.WebActivity;

/**
 * Created by zhangluya on 2017/3/20.
 */

public class Navigation {

    private static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    public static Navigation getInstance() {
        return INSTANCE;
    }

    public void openDetails(@NonNull Context context, @NonNull String newsId) {
        Intent intent = new Intent(context, TopicsDetailActivity.class);
        intent.putExtra("newsId", newsId);
        context.startActivity(intent);
    }

    public void openWebBrowser(@NonNull Context context, @NonNull String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public void openAddReply(@NonNull Context context, @NonNull String title) {
        Intent intent = new Intent(context, AddReplyActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    public static class IntentReceiver {

        private static final IntentReceiver INSTANCE = new IntentReceiver();

        private IntentReceiver() {
        }

        public static IntentReceiver getInstance() {
            return INSTANCE;
        }

        public
        @Nullable
        String getNewsId(@NonNull Activity activity) {
            Intent intent = activity.getIntent();
            return intent.getStringExtra("newsId");
        }


        public
        @Nullable
        String getUrl(@NonNull Activity activity) {
            return activity.getIntent().getStringExtra("url");
        }

        public
        @Nullable
        String getTitle(@NonNull Activity activity) {
            return activity.getIntent().getStringExtra("title");
        }

    }
}