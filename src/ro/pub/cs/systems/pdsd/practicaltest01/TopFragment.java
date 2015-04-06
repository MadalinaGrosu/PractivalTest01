package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TopFragment extends Fragment {
	private ButtonOnClickListener buttonOnClickListener = new ButtonOnClickListener();
	
	private class ButtonOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int buttonId = v.getId();
			if (buttonId == R.id.showHideButton) { // show/hide additional details
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				DownFragment additionalDetailsFragment = (DownFragment)fragmentManager.findFragmentById(R.id.fragment2);
				if (additionalDetailsFragment == null) {
				  fragmentTransaction.add(R.id.fragment2, new DownFragment());
				  ((Button) v).setText("Less details");
				  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
				} else {
				  fragmentTransaction.remove(additionalDetailsFragment);
				  ((Button)v).setText("More details");
				  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK);
				}
				fragmentTransaction.commit();
			}
				
		}
		
	};
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.top_frame, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Button additionalDetailsButton = (Button)getActivity().findViewById(R.id.showHideButton);
		additionalDetailsButton.setOnClickListener(buttonOnClickListener);
		
	}

}
