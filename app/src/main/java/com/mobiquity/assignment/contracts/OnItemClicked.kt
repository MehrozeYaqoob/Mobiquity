package com.mobiquity.assignment.contracts

import com.mobiquity.assignment.model.Product

/**
 * Created by Mehroze on 11/18/2019.
 */
interface OnItemClicked {
    fun itemClicked(product : Product)
}