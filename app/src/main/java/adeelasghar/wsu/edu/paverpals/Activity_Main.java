package adeelasghar.wsu.edu.paverpals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Main extends AppCompatActivity {

    EditText txtDrivewayText, txtSidewalkText, txtLaborText;
    EditText txtConcreteText, txtAsphaltText, txtLaborCostText;
    Button btnCalculate;

    int driveway=0, sidewalk=0, labor=0;
    int concrete=0, asphalt=0, laborCost=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        txtDrivewayText = findViewById(R.id.txtDrivewayInput);
        txtSidewalkText = findViewById(R.id.txtSidewalkInput);
        txtLaborText = findViewById(R.id.txtLaborInput);

        txtConcreteText = findViewById(R.id.txtConcreteOutput);
        txtAsphaltText = findViewById(R.id.txtAsphaltOutput);
        txtLaborCostText = findViewById(R.id.txtDollarsOutput);

        btnCalculate = findViewById(R.id.btnCalculate);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driveway = txtDrivewayText.getText().toString().equals("") ? 0 : Integer.parseInt(txtDrivewayText.getText().toString());
                if(driveway<100 || driveway>1000){
                    showToast("Driveway area must be between 100-1000!");
                }

                sidewalk = txtSidewalkText.getText().toString().equals("") ? 0 : Integer.parseInt(txtSidewalkText.getText().toString());
                if(sidewalk<100 || sidewalk>1000){
                    showToast("Sidewalk area must be between 100-1000!");
                }

                labor = txtLaborText.getText().toString().equals("") ? 0 : Integer.parseInt(txtLaborText.getText().toString());
                if(labor<10 || labor>100){
                    showToast("Labor hours must be between 10-100!");
                }


                if((driveway>=100 &&  driveway<=1000) && (sidewalk>=100 && sidewalk<=1000) && (labor>=10 && labor<=100) ){
                    concrete = 75 * (driveway + sidewalk);
                    asphalt = 25 * (driveway + sidewalk);
                    laborCost = labor * 50;

                    txtConcreteText.setText(""+concrete);
                    txtAsphaltText.setText(""+asphalt);
                    txtLaborCostText.setText(""+laborCost);
                }
            }
        });
    }

    private void showToast(String error){
        Toast.makeText(Activity_Main.this, error, Toast.LENGTH_SHORT).show();
    }

}
