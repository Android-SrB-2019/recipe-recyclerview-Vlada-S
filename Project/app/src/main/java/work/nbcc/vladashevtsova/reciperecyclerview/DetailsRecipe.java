package work.nbcc.vladashevtsova.reciperecyclerview;

//Vlada Shevtsova
//March 17 2019

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details_recipe );

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra( "name" ) && getIntent().hasExtra( "image" ) &&
                getIntent().hasExtra( "directions" ) && getIntent().hasExtra( "ingredients" )){
            String name = getIntent().getStringExtra( "name" );
            String directions = getIntent().getStringExtra( "directions" );
            String ingredients = getIntent().getStringExtra( "ingredients" );
            String image = getIntent().getStringExtra( "image" );
            setValues( name, ingredients, directions, image );
        }
    }

    //sets the values from intent to the views on the page with the recipe details
    private void setValues(String name, String ingredients, String directions, String image){
        //loads content into the text views
        TextView nameView = findViewById( R.id.name );
        TextView ingredientsName = findViewById( R.id.ingredients_name );
        TextView ingredientsView = findViewById( R.id.ingredients );
        TextView directionsName = findViewById( R.id.directions_name );
        TextView directionsView = findViewById( R.id.directions );
        ImageView imageView = findViewById( R.id.image );
        nameView.setText( name );
        ingredientsName.setText( getString(R.string.ingredients) );
        ingredientsView.setText( ingredients );
        directionsName.setText( R.string.directions );
        directionsView.setText( directions );

        //loads image
        Picasso.get()
                .load(image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
