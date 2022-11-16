package com.example.mobiiliohjelmointiprojekti.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity
data class Arvostelu(
@PrimaryKey val arvosteluid: Int,
 val teksti : String,
 val arvosana : Int
)
@Entity(
 foreignKeys = [ForeignKey(
  entity = Arvostelu::class,
  parentColumns = arrayOf("arvosteluid"),
  childColumns = arrayOf("elokuvaid"),
  onDelete = ForeignKey.CASCADE
 ),
 ForeignKey(
  entity = Arvostelu::class,
  parentColumns = arrayOf("arvosteluid"),
  childColumns = arrayOf("kayttajaid"),
  onDelete = ForeignKey.CASCADE
 )]
)
data class Elokuva(
 @PrimaryKey val elokuvaid: Int,
 val nimi : String,
)
@Entity
data class Kayttaja(
 @PrimaryKey val kayttajaid : Int,
 val tunnus : String,
 val salasana : String
)