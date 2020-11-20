package com.aysegul.tahminbulma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    var sayac = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tahminButton.setOnClickListener {
            tahminKontrol(it)

        }
    }

    fun tahminKontrol(it: View){
        var tahmin = tahminText.text.toString().toInt()
        val sayi = arguments?.getInt("sayi",1)

        if(tahmin == sayi){
            val action1 = SecondFragmentDirections.actionSecondFragmentToWinFragment()
            Navigation.findNavController(it).navigate(action1)
        }else{
            sayac++
            if(sayac == 3){
                val action2 = SecondFragmentDirections.actionSecondFragmentToLostFragment()
                Navigation.findNavController(it).navigate(action2)
            }else{
                Toast.makeText(context,"Tekrar Deneyiniz! ${3-sayac} hakkiniz Kaldi",Toast.LENGTH_LONG).show()
                println(sayac)
            }
        }
    }

}