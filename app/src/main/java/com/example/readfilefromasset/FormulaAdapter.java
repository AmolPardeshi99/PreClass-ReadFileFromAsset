package com.example.readfilefromasset;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FormulaAdapter extends RecyclerView.Adapter<FormulaViewHolder> {
    private List<FormulasModel> formulasModelList;

    public FormulaAdapter(List<FormulasModel> formulasModelList) {
        this.formulasModelList = formulasModelList;
    }

    @NonNull
    @Override
    public FormulaViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new FormulaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulaViewHolder holder, int position) {
        FormulasModel formulasModel = formulasModelList.get(position);
        holder.setData(formulasModel);
    }

    @Override
    public int getItemCount() {
        return formulasModelList.size();
    }

    public void UpdateList(List<FormulasModel> formulasModelList){
        this.formulasModelList = formulasModelList;
        notifyDataSetChanged();
    }
}
