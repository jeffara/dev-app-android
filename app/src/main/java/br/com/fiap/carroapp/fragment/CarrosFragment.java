package br.com.fiap.carroapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.fiap.carroapp.R;
import br.com.fiap.carroapp.adapter.CarroAdapter;
import br.com.fiap.carroapp.model.CarroBean;
import br.com.fiap.carroapp.service.CarroService;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrosFragment extends Fragment {


    private RecyclerView rvCarros;
    private LinearLayoutManager layoutManager;
    private List<CarroBean> carros;
    private int tipo;

    public CarrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            tipo = getArguments().getInt("tipo");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_carros, container, false);

        rvCarros = (RecyclerView) view.findViewById(R.id.rvCarrosID);

        //Utilizado para fazer o controle da lista
        layoutManager = new LinearLayoutManager(getContext());

        rvCarros.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    //Metodo executado apos o onCreateView
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        taskCarros();

    }

    private void taskCarros() {

        CarroService carroService = new CarroService(getContext());
        carros = carroService.getCarros(carroService.loadJSONFromRaw(tipo));

        rvCarros.setAdapter(new CarroAdapter(getContext(), carros));
    }
}
