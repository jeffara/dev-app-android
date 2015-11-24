package br.com.fiap.carroapp.service;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.carroapp.model.CarroBean;

/**
 * Created by jeff on 11/19/15.
 */
public class CarroService {

        private Context context;
        public CarroService(Context context) {
            this.context = context;
        }
        public String loadJSONFromAsset(int idRaw) {
            String json;
            try {
                //InputStream is = context.getResources().openRawResource(R.raw.carros_esportivos);
                InputStream is = context.getResources().openRawResource(idRaw);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }

        public List<CarroBean> getCarros(String jsonString) {
            List<CarroBean> carros = new ArrayList<>();
            try{
                JSONObject json = new JSONObject(jsonString);
                JSONObject jsonListCarros = json.getJSONObject("carros");
                JSONArray jArray = jsonListCarros.getJSONArray("carro");

                for(int i=0; i<jArray.length(); i++){
                    CarroBean carro = new CarroBean();
                    JSONObject json_data = jArray.getJSONObject(i);
                    carro.setDescricao(json_data.getString("desc"));
                    carro.setFoto(json_data.getString("foto"));
                    carro.setNome(json_data.getString("nome"));
                    carros.add(carro);
                }
            } catch(JSONException je) {
                je.printStackTrace();
            }
            return carros;
    }
}
