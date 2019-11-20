package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.polinema.idealbodyweight.Fragment.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragment.MenuFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener{

	// Deklarasikan atribut Fragment di sini
	MenuFragment menuFragment;
	private AboutFragment aboutFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = aboutFragment.newInstance("Aditya Yusuf Raharja");
		menuFragment= new  MenuFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);

		return  true;


	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId()== R.id.menu_about)
			getSupportFragmentManager().beginTransaction()
			.replace(R.id.fragment_container,aboutFragment)
			.addToBackStack(null).commit();


		// TODO: Tambahkan penanganan menu di sini

		return super.onOptionsItemSelected(item);
	}
}
