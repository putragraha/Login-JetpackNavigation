package nsystem.loginjetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import nsystem.loginjetpacknavigation.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private var binding: FragmentLoginBinding? = null

    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            etUsername.setText(args.username)
            btnLogin.setOnClickListener {
                val username = this.etUsername.text.toString()
                val action: NavDirections = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    username
                )
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}