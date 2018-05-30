package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.shr_login_fragment, container, false)

        layout.next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                password_text_input.error = null
                // navigate to next fragment
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        // Clear error once password is valid
        layout.next_button.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!))
                password_text_input.error = null
            false
        }

        return layout
    }

    private fun isPasswordValid(text: Editable?): Boolean = text != null && text.length >= 8
}

