@file:Suppress("NOTHING_TO_INLINE")

package mimi.o.browser4g.extensions

import mimi.o.browser4g.dialog.BrowserDialog
import androidx.appcompat.app.AlertDialog

/**
 * Ensures that the dialog is appropriately sized and displays it.
 */
inline fun AlertDialog.Builder.resizeAndShow() = BrowserDialog.setDialogSize(context, this.show())
