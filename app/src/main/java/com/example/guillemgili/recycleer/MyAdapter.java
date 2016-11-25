package com.example.guillemgili.recycleer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by guillem.gili on 11/25/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterViewHolder>{

    ArrayList<Contact> contactos;

    MyAdapter(){
        contactos = new ArrayList<>();
        contactos.add(new Contact(0,"Benito Camela","123456789"));
        contactos.add(new Contact(0,"Alberto Carlos Huevos","123456789"));
        contactos.add(new Contact(1,"Lola Mento","123456789"));
        contactos.add(new Contact(0,"Aitor Tilla","123456789"));
        contactos.add(new Contact(0,"Elvis Teck","123456789"));
        contactos.add(new Contact(1,"Débora Dora","123456789"));
        contactos.add(new Contact(0,"Borja Món de York","123456789"));
        contactos.add(new Contact(1,"Encarna Vales","123456789"));
        contactos.add(new Contact(0,"Enrique Cido","123456789"));
        contactos.add(new Contact(0,"Francisco Jones","123456789"));
        contactos.add(new Contact(1,"Estela Gartija","123456789"));
        contactos.add(new Contact(0,"Andrés Trozado","123456789"));
        contactos.add(new Contact(0,"Carmelo Cotón","123456789"));
        contactos.add(new Contact(0,"Alberto Mate","123456789"));
        contactos.add(new Contact(0,"Chema Pamundi","123456789"));
        contactos.add(new Contact(0,"Armando Adistancia","123456789"));
        contactos.add(new Contact(1,"Helena Nito Del Bosque","123456789"));
        contactos.add(new Contact(0,"Unai Nomás","123456789"));
        contactos.add(new Contact(1,"Ester Colero","123456789"));
        contactos.add(new Contact(0,"Marcos Corrón","123456789"));
    }


    @Override
    public MyAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Instancia un layout XML en la correspondiente vista.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Inflamos en la vista el layout para cada elemento
        View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.AdapterViewHolder adapterViewholder, int position) {
        int iconLayout = contactos.get(position).getIcon();
        //Dependiendo del entero se asignará una imagen u otra
        adapterViewholder.info.setText(contactos.get(position).getName());
        adapterViewholder.frame.setBackgroundResource(R.drawable.button);
    }

    @Override
    public int getItemCount() {
        //Debemos retornar el tamaño de todos los elementos contenidos en el viewholder
        //Por defecto es return 0 --> No se mostrará nada.
        return contactos.size();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact item = this.contactos.get(position);
        Toast.makeText(getActivity(),item.getName() + " Clicked!", ,
                Toast.LENGTH_SHORT).show();
    }
    //Definimos una clase viewholder que funciona como adapter para
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        /*
        *  Mantener una referencia a los elementos de nuestro ListView mientras el usuario realiza
        *  scrolling en nuestra aplicación. Así que cada vez que obtenemos la vista de un item,
        *  evitamos las frecuentes llamadas a findViewById, la cuál se realizaría únicamente la primera vez y el resto
        *  llamaríamos a la referencia en el ViewHolder, ahorrándonos procesamiento.
        */
        public ImageView frame;
        public TextView info;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.frame= (ImageView) itemView.findViewById(R.id.frame);
            this.v = itemView;
            this.info = (TextView) itemView.findViewById(R.id.info_text);

        }
    }
}
