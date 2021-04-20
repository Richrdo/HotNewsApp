package com.example.hotnewsapp.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import java.io.Serializable;

public class News extends BaseObservable implements Serializable {

    private String title;
    private String content;
    private String source;
    private String date;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
        notifyPropertyChanged(BR.source);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    //    public final ObservableField<String> title= new ObservableField<>();
//    public final ObservableField<String> source= new ObservableField<>();
//    public final ObservableField<String> data= new ObservableField<>();
//    public final ObservableField<String> context= new ObservableField<>();
//
//    public News() {
//
//    }
//
////
////    public void setTitle(String title){
////        this.title.set(title);
////    }
////
////    public void setSource(String source){
////        this.source.set(source);
////    }
////
////    public void setData(String data){
////        this.data.set(data);
////    }
////
////    public void setContext(String context){
////        this.context.set(context);
////    }
//
//    @Bindable
//    public ObservableField<String> getTitle() {
//        return title;
//    }
//
//    @Bindable
//    public ObservableField<String> getSource() {
//        return source;
//    }
//
//    @Bindable
//    public ObservableField<String> getData() {
//        return data;
//    }
//
//    @Bindable
//    public ObservableField<String> getContext() {
//        return context;
//    }
//
//    @Override
//    public String toString() {
//        return "News{" +
//                "title='" + title.get() + '\'' +
//                ", source='" + source.get() + '\'' +
//                ", data='" + data.get() + '\'' +
//                ", context='" + context.get() + '\'' +
//                '}';
//    }

}
