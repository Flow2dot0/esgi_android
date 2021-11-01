package com.florian.gustin.presentation

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.florian.gustin.R
import com.florian.gustin.domain.Product
import com.squareup.picasso.Picasso

class YukaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yuka)
        val product = Product.petitPoisEtCarottes()
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_drawable))

        val pics = Picasso.get().load(product.imageUrl).into(findViewById<ImageView>(R.id.pics))
//        val score = findViewById<ImageView>(R.id.score)
//        score.setImageDrawable(Drawable.createFromPath("@drawable/nutriscore_e"))
        findViewById<TextView>(R.id.title).text = product.name
        findViewById<TextView>(R.id.brand).text = product.brand

        valueOfText(R.id.barcode, R.string.barcode, product.barcode.toString())
        valueOfText(R.id.quantity, R.string.quantity, product.toString())
        valueOfText(R.id.sold, R.string.sold, product.countries.formatItemsFromList())
        valueOfText(R.id.ingredients, R.string.ingredients, product.ingredients.formatItemsFromList())
        valueOfText(R.id.allergenes, R.string.allergenes, product.allergenes.formatItemsFromList())
        valueOfText(R.id.additives, R.string.additives, product.additives.formatItemsFromList())

    }

    private fun valueOfText(rId : Int, rString : Int, args : String){
        findViewById<TextView>(rId).setTextBold(getString(rString, args))
    }



    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }

    private fun List<String>.formatItemsFromList() : String{
        return this.toString().substring(1, this.toString().length-1)
    }
}