package com.example.mobiiliohjelmointiprojekti.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Arvostelu(
    @PrimaryKey(autoGenerate = true) val arvosteluid: Int,
    val otsikko : String,
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
    @PrimaryKey(autoGenerate = true) val elokuvaid: Int,
    val nimi : String,
)
@Entity
data class Kayttaja(
    @PrimaryKey(autoGenerate = true) val kayttajaid : Int,
    @ColumnInfo(name = "user_name")
    val tunnus : String,
    val salasana : String
)