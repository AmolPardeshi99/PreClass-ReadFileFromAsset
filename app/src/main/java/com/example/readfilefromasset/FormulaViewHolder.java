package com.example.readfilefromasset;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FormulaViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvFormulaName;
    private TextView mTvFormulaUrl;
    public FormulaViewHolder(@NonNull View itemView) {
        super(itemView);
        mTvFormulaName = itemView.findViewById(R.id.tvFormulaName);
        mTvFormulaUrl = itemView.findViewById(R.id.FormulaUrl);
    }

    public void setData(FormulasModel formulamodel){
        mTvFormulaUrl.setText(formulamodel.getUrl());
        mTvFormulaName.setText(formulamodel.getFormulae());
    }
}
