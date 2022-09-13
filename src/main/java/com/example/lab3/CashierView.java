package com.example.lab3;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField cash,c1k,c500,c100,c20,c10,c5,c1;
    private Button cal;


    public CashierView() {
        cash = new TextField("เงินทอน");
        c1k = new TextField();
        c500 = new TextField();
        c100 = new TextField();
        c20 = new TextField();
        c10 = new TextField();
        c5 = new TextField();
        c1 = new TextField();
        cal = new Button("คำนวณเงินทอน");

        cash.setPrefixComponent(new Span("$"));
        c1k.setPrefixComponent(new Span("$1000: "));
        c500.setPrefixComponent(new Span("$500: "));
        c100.setPrefixComponent(new Span("$100: "));
        c20.setPrefixComponent(new Span("$20: "));
        c10.setPrefixComponent(new Span("$10: "));
        c5.setPrefixComponent(new Span("$5: "));
        c1.setPrefixComponent(new Span("$1: "));

        this.add(cash,cal,c1k,c500,c100,c20,c10,c5,c1);

        cal.addClickListener(event ->{
            String ans = cash.getValue();
            Change change = WebClient.create().get().uri("http://localhost:8080/getChange/"+ans+"").retrieve().bodyToMono(Change.class).block();
            c1k.setValue(change.getB1000()+"");
            c500.setValue(change.getB500()+"");
            c100.setValue(change.getB100()+"");
            c20.setValue(change.getB20()+"");
            c10.setValue(change.getB10()+"");
            c5.setValue(change.getB5()+"");
            c1.setValue(change.getB1()+"");

        });


    }

}
