package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry
import kotlinx.android.synthetic.main.shr_product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.shr_product_grid_fragment, container, false)
        // setup toolbar
        (activity as AppCompatActivity).setSupportActionBar(layout.app_bar)
        // setup recycler view
        layout.recycler_view.setHasFixedSize(true)
        layout.recycler_view.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(ProductEntry.initProductEntryList(resources))
        layout.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
        layout.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        // return layout
        return layout
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
