package br.com.fiap.organicfarmers

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.google.android.material.chip.Chip

data class FilterItem(
  val id: Int,
  val text: String,
  @DrawableRes val icon: Int? = null,
  @DrawableRes val closeIcon: Int? = null,

)

fun FilterItem.toChip(context: Context): Chip {

  val chip = LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip

  if (closeIcon != null) chip.setChipBackgroundColorResource(R.color.white)

  chip.setChipStrokeColorResource(R.color.gray)

  chip.chipStrokeWidth = 2f

  chip.text = text

  return chip
}