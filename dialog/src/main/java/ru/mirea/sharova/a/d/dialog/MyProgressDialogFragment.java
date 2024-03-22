package ru.mirea.sharova.a.d.dialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {

    private static final int MAX_PROGRESS = 100;
    private int currentProgress = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Hello world!")
                .setMessage("Подождите")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        final AlertDialog progressDialog = builder.create();
        progressDialog.show();

        simulateProgress(progressDialog);

        return progressDialog;
    }

    private void simulateProgress(final AlertDialog dialog) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentProgress++;
                dialog.setMessage("Выполнено " + currentProgress + "%");

                if (currentProgress < MAX_PROGRESS) {
                    handler.postDelayed(this, 100);
                } else {
                    dialog.dismiss();
                }
            }
        }, 100);
    }
}
