package com.example.lab3;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;



@Route(value = "index1")
public class MathView extends VerticalLayout {
    private MathAPI c;

    public MathView(){
        c = new MathAPI();
        double num3 = 0;
        TextField txt1 = new TextField();
        txt1.setLabel("number1");
        txt1.addValueChangeListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
        });
        add(txt1);

        TextField txt2 = new TextField();
        txt2.setLabel("number2");
        txt1.addValueChangeListener(event ->{
            double num2 = Double.parseDouble(txt2.getValue());
        });
        add(txt2);
        TextArea txt3 = new TextArea("Answer");
        add(txt3);

        HorizontalLayout h1 = new HorizontalLayout();

        Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        h1.add(plusButton);
        plusButton.addClickListener(event ->{
           String ans;
           String num1 = String.valueOf(txt1.getValue());
           String num2 = String.valueOf(txt2.getValue());
           ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2+"").retrieve().bodyToMono(String.class).block());
           txt3.setValue(ans);
        });

        Button minusButton = new Button(new Icon("lumo","minus"));
        h1.add(minusButton);
        minusButton.addClickListener(event ->{
            String ans;
            String num1 = String.valueOf(txt1.getValue());
            String num2 = String.valueOf(txt2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2+"").retrieve().bodyToMono(String.class).block());
            txt3.setValue(ans);
        });


        Button multButton = new Button(new Icon("lumo","cross"));
        h1.add(multButton);
        multButton.addClickListener(event ->{
            String ans;
            String num1 = String.valueOf(txt1.getValue());
            String num2 = String.valueOf(txt2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/multiply/"+num1+"/"+num2+"").retrieve().bodyToMono(String.class).block());
            txt3.setValue(ans);
        });

        Button divButton = new Button("/");
        h1.add(divButton);
        divButton.addClickListener(event ->{
            String ans;
            String num1 = String.valueOf(txt1.getValue());
            String num2 = String.valueOf(txt2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2+"").retrieve().bodyToMono(String.class).block());
            txt3.setValue(ans);
        });

        Button modButton = new Button("Mod");
        h1.add(modButton);
        modButton.addClickListener(event ->{
            String ans;
            String num1 = String.valueOf(txt1.getValue());
            String num2 = String.valueOf(txt2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2+"").retrieve().bodyToMono(String.class).block());
            txt3.setValue(ans);
        });

        Button maxButton = new Button("Max");
        h1.add(maxButton);
        maxButton.addClickListener(event ->{
            String ans;
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", txt1.getValue());
            formData.add("num2", txt2.getValue());
            ans = String.valueOf(WebClient.create().post().uri("http://localhost:8080/max").contentType(MediaType.APPLICATION_FORM_URLENCODED).body(BodyInserters.fromFormData(formData)).retrieve().bodyToMono(String.class).block());
            txt3.setValue(ans);
        });
        this.add(h1);


    }
}
