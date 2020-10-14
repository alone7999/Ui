package dev.armoury.android.ui

import androidx.databinding.ViewDataBinding
import dev.armoury.android.viewmodel.ArmouryListViewModel

abstract class ArmouryBottomSheetListDialog<T : ViewDataBinding, V : ArmouryListViewModel<*>> :
    ArmouryBottomSheetDialogFragment<T, V>()