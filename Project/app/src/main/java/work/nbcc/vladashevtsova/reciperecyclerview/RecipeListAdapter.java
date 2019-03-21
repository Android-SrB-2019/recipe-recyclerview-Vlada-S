package work.nbcc.vladashevtsova.reciperecyclerview;

//Vlada Shevtsova
//March 17 2019

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends
        RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private Context context;


    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView wordItemView1;


        public RecipeViewHolder(View itemView) {
            super( itemView );
            wordItemView = itemView.findViewById( R.id.word );
            wordItemView1 = itemView.findViewById( R.id.word1 );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mWordList.
            Recipe element = mRecipeList.get( mPosition );

            Intent intent = new Intent( context, DetailsRecipe.class );
            intent.putExtra("name", element.name);
            intent.putExtra( "ingredients", element.ingredients );
            intent.putExtra( "directions", element.directions );
            intent.putExtra( "image", element.image );

            context.startActivity( intent );
        }
    }

    public RecipeListAdapter(LinkedList<Recipe> recipeList, Context context) {
//        mInflater = LayoutInflater.from( context );
        this.mRecipeList = recipeList;
        this.context = context;
    }


    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.recipe_items, parent, false );
        RecipeViewHolder rvh = new RecipeViewHolder( v );
        return rvh;

    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        Recipe mCurrent = mRecipeList.get( position );
        // Add the data to the view holder.
        holder.wordItemView.setText( mCurrent.name );
        holder.wordItemView1.setText( mCurrent.description );
    }


    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
