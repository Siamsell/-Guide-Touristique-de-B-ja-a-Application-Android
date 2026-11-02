package com.siham.guidetoristique;

import java.util.Arrays;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.siham.guidetoristique.models.Site;
import com.siham.guidetoristique.models.SiteImage;
import com.siham.guidetoristique.models.SiteType;
import android.content.pm.PackageManager;

import java.util.ArrayList;

public class Generator {
    public static void setupCallButton(final Context context, final TextView phone, Button btnCall) {
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phone.getText().toString(); // Récupère le numéro de téléphone
                if (!phoneNumber.isEmpty()) {
                    // Vérification de la présence de la fonctionnalité téléphonique sur l'appareil
                    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                        // Si la fonctionnalité téléphonique est présente
                        Intent callIntent = new Intent(Intent.ACTION_DIAL); // Utilise ACTION_DIAL pour ouvrir l'application de téléphone
                        callIntent.setData(Uri.parse("tel:" + phoneNumber)); // Prépare l'appel avec le numéro
                        context.startActivity(callIntent); // Lance l'intent
                    } else {
                        Toast.makeText(context, "Cet appareil ne prend pas en charge les appels", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Numéro de téléphone non disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void setupEmailButton(final Context context, final TextView email, Button btnEmail) {
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = email.getText().toString(); // Récupère l'adresse email
                if (!emailAddress.isEmpty()) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO); // Utilise ACTION_SENDTO pour envoyer un email
                    emailIntent.setData(Uri.parse("mailto:" + emailAddress)); // Prépare l'URI de l'email
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Objet de l'email"); // Optionnel : ajoute un objet
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Texte du message"); // Optionnel : ajoute un corps de message
                    context.startActivity(Intent.createChooser(emailIntent, "Choisir une application de messagerie")); // Lance l'intent pour choisir l'application
                } else {
                    Toast.makeText(context, "Adresse email non disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static void setupSmsButton(final Context context, final TextView phone, Button btnSms) {
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phone.getText().toString();
                if (!phoneNumber.isEmpty()) {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setData(Uri.parse("smsto:" + phoneNumber)); // ou "sms:" + phoneNumber
                    smsIntent.putExtra("sms_body", "Bonjour, je suis intéressé par votre site touristique.");
                    context.startActivity(smsIntent);
                } else {
                    Toast.makeText(context, "Numéro de téléphone non disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static ArrayList<Site> generateSites(Context context, String type) {
        ArrayList<Site> sites = new ArrayList<>();

        switch (type) {
            case SiteType.HOTEL:
                sites.add(new Site(3, context.getString(R.string.hotel_atlantis),
                        context.getString(R.string.hotel_atlantis_desc),
                        "0560190310", "atlantishotel@gmail.com", SiteType.HOTEL,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_7),
                                new SiteImage(R.drawable.img_53),
                                new SiteImage(R.drawable.img_54),
                                new SiteImage(R.drawable.hotel)
                        )),
                        Arrays.asList("★★★★ahmed,Great stay and very welcoming staff!",
                                "★★★★★siham,Clean and spacious rooms.",
                                "★★★★Fatma,Very varied breakfast.",
                                "★★★★ rania,Ideal location close to everything."),
                        context.getString(R.string.hotel_atlantis_location))); // Add location here

                sites.add(new Site(3, context.getString(R.string.hotel_nord),
                        context.getString(R.string.hotel_nord_desc),
                        "034128585", "hoteldunord@gmail.com", SiteType.HOTEL,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_8),
                                new SiteImage(R.drawable.img_12)
                        )),
                        Arrays.asList("★★★★★islem,Very calm and relaxing.",
                                "★★★★AMINA,Responsive customer service.",
                                "★★★AHLEMBeautiful interior decoration.",
                                "★★★★AKRAM:Excellent in-house restaurant."),
                        context.getString(R.string.hotel_nord_location))); // Add location here

                sites.add(new Site(3, context.getString(R.string.hotel_lac),
                        context.getString(R.string.hotel_lac_desc),
                        "0770757767", "hoteldulac@gmail.com", SiteType.HOTEL,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_9),
                                new SiteImage(R.drawable.img_56),
                                new SiteImage(R.drawable.img_57)
                        )),
                        Arrays.asList("★★★★★AMEL:Magnificent view of the lake!",
                                "★★★★ADEM,Very clean and well maintained.",
                                "★★★★NOUR:Excellent value for money.",
                                "★★★★★ALI:Friendly and helpful staff."),
                        context.getString(R.string.hotel_lac_location))); // Add location here

                break;
            case SiteType.RESTAURANT:
                sites.add(new Site(2, context.getString(R.string.restaurant_table_gourmande),
                        context.getString(R.string.restaurant_table_gourmande_desc),
                        "0567889901", "table_gourmand@gmail.com", SiteType.RESTAURANT,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_10),
                                new SiteImage(R.drawable.restr)
                        )),
                        Arrays.asList("★★★★★OUSSAMA:Delicious and well-presented dishes.",
                                "★★★★WALID:Very pleasant atmosphere.",
                                "★★★★ANOUAR:Very professional staff.",
                                "★★★★SANA:Reasonable prices for the quality."),
                        context.getString(R.string.restaurant_table_gourmande_location))); // Add location here

                sites.add(new Site(2, context.getString(R.string.restaurant_maison_opera),
                        context.getString(R.string.restaurant_maison_opera_desc),
                        "0677821212", "MAISON_OPERA@gmail.com", SiteType.RESTAURANT,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_46),
                                new SiteImage(R.drawable.img_47),
                                new SiteImage(R.drawable.img_48)
                        )),
                        Arrays.asList("★★★★★BADRELDINNE:Excellent service.",
                                "★★★★ AMINE:Very good tasting menu.",
                                "★★★★★YOUCEF:Chic and calm setting.",
                                "★★★★LEILA:Desserts are to die for!"),
                        context.getString(R.string.restaurant_maison_opera_location))); // Add location here

                sites.add(new Site(2, context.getString(R.string.restaurant_atbaq),
                        context.getString(R.string.restaurant_atbaq_desc),
                        "0771334523", "atbaq@gmail.com", SiteType.RESTAURANT,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_46),
                                new SiteImage(R.drawable.img_50),
                                new SiteImage(R.drawable.img_51)
                        )),
                        Arrays.asList("★★★★IMANE:Best couscous in the region!",
                                "★★★★★ABDELALLAHFast and efficient service.",
                                "★★★★SMAIL:Magnificent traditional decor.",
                                "Good portion for the price."),
                        context.getString(R.string.restaurant_atbaq_location))); // Add location here
                break;

            case SiteType.JARDIN:
                sites.add(new Site(4, context.getString(R.string.park_fleur),
                        context.getString(R.string.park_fleur_desc),
                        "0556789311", "parcfleures@gmail.com", SiteType.JARDIN,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_22),
                                new SiteImage(R.drawable.img_21)
                        )),
                        Arrays.asList("★★★★★LILYA:Beautiful flowers everywhere!",
                                "★★★★★HADIL:Perfect for families.",
                                "★★★★★IKRAM:Very clean and safe.",
                                "★★★★FATMA:Peaceful place to relax."),
                        context.getString(R.string.park_fleur_location))); // Add location here

                sites.add(new Site(4, context.getString(R.string.park_rose),
                        context.getString(R.string.park_rose_desc),
                        "0558938011", "rose_bej@gmail.com", SiteType.JARDIN,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_22),
                                new SiteImage(R.drawable.img_23)
                        )),
                        Arrays.asList("ALI:Many varieties of roses.",
                                "★★★★★AFNANE:Well-maintained paths.",
                                "★★★★MERYEM:Playground for kids.",
                                "★★★★★INES:Ideal for picnics."),
                        context.getString(R.string.park_rose_location))); // Add location here

                sites.add(new Site(4, context.getString(R.string.park_loisir),
                        context.getString(R.string.park_loisir_desc),
                        "0509244143", "jardindeloisir_bej@gmail.com", SiteType.JARDIN,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_24),
                                new SiteImage(R.drawable.img_25)
                        )),
                        Arrays.asList("★★★★ahmed,Various activities for all ages.",
                                "★★★★★amina,Great place for jogging.",
                                "★★★★salim,Beautiful panoramic view."),
                        context.getString(R.string.park_loisir_location))); // Add location here

                break;

            case SiteType.BEACHES:
                sites.add(new Site(4, context.getString(R.string.beach_boulimat),
                        context.getString(R.string.beach_boulimat_desc),
                        "0785358321", "BOULIMAT@gmail.com", SiteType.BEACHES,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_27),
                                new SiteImage(R.drawable.img_28),
                                new SiteImage(R.drawable.img_29)
                        )),
                        Arrays.asList("★★★★★AKRAM:Clear water and fine sand.",
                                "★★★★★ALIPerfect for swimming.",
                                "★★★★★IMANE:Parking available nearby.",
                                "Lots of shaded areas."),
                        context.getString(R.string.beach_boulimat_location))); // Add location here

                sites.add(new Site(4, context.getString(R.string.beach_sahel),
                        context.getString(R.string.beach_sahel_desc),
                        "0785355671", "SAHEL@gmail.com", SiteType.BEACHES,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_30),
                                new SiteImage(R.drawable.img_31),
                                new SiteImage(R.drawable.img_32)
                        )),
                        Arrays.asList("★★★★ AHLEM :Clean and quiet beach.",
                                "★★★★ SIHAM :Friendly atmosphere.",
                                "★★★★  AMINE :Ideal for children.",
                                "★★★★★ AHMED :Good restaurants nearby."),
                        context.getString(R.string.beach_sahel_location))); // Add location here

                break;

            case SiteType.MUSEUMS:
                sites.add(new Site(4, context.getString(R.string.museum_bordj),
                        context.getString(R.string.museum_bordj_desc),
                        "053456999", "musse@gmail.com", SiteType.MUSEUMS,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_34),
                                new SiteImage(R.drawable.img_35)
                        )),
                        Arrays.asList("★★★★★   ISLEM :Very educational.",
                                "★★★★   INES :Impressive collections.",
                                "★★★★★  NIHAD :Very knowledgeable staff.",
                                "★★★★★  MAROUA :Perfect for history enthusiasts."),
                        context.getString(R.string.museum_bordj_location))); // Add location here

                sites.add(new Site(4, context.getString(R.string.museum_el_moudjahid),
                        context.getString(R.string.museum_el_moudjahid_desc),
                        "0546095392", "elmoudjahid@gmail.com", SiteType.MUSEUMS,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_36),
                                new SiteImage(R.drawable.img_37)
                        )),
                        Arrays.asList("★★★★★   IKRAM : Well documented.",
                                "★★★★   ISLEM :Emotional museum.",
                                "★★★★   KAMEL :A must-see visit.",
                                "★★★★   KARIM :Respect for our heritage."),
                        context.getString(R.string.museum_el_moudjahid_location))); // Add location here
                break;

            case SiteType.TOURIST:
                sites.add(new Site(4, context.getString(R.string.site_casbah),
                        context.getString(R.string.site_casbah_desc),
                        "0677777172", "bejaia_Casbah@gmail.com", SiteType.TOURIST,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_38),
                                new SiteImage(R.drawable.img_39),
                                new SiteImage(R.drawable.img_40),
                                new SiteImage(R.drawable.img_6)
                        )),
                        Arrays.asList("★★★★   MARAM :Fascinating history.",
                                "★★★★   MOHAMMED :Unique architecture.",
                                "★★★★★  AKRAM :Breathtaking view.",
                                "★★★★★  KAMEL :A true local treasure."),
                        context.getString(R.string.site_casbah_location))); // Add location here

                sites.add(new Site(4, context.getString(R.string.site_cap_carbon),
                        context.getString(R.string.site_cap_carbon_desc),
                        "0685864502", "bejaiaCapCarbon@gmail.com", SiteType.TOURIST,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_41),
                                new SiteImage(R.drawable.img_42),
                                new SiteImage(R.drawable.img_43)
                        )),
                        Arrays.asList("★★★★★ RANIA : Exceptional panoramic view.",
                                "★★★★★ FATMA : Many hiking trails.",
                                "★★★★★ SIHAM : Magical place at sunset.",
                                "★★★★★  IKRAM :Guaranteed clean air and calm."),
                        context.getString(R.string.site_cap_carbon_location))); // Add location here
                break;

            case SiteType.MONTAINS:
                sites.add(new Site(4, context.getString(R.string.mountain_yema),
                        context.getString(R.string.mountain_yema_desc),
                        "052536953", "yemagouraya@gmail.com", SiteType.MONTAINS,
                        new ArrayList<>(Arrays.asList(
                                new SiteImage(R.drawable.img_44),
                                new SiteImage(R.drawable.img_45)
                        )),
                        Arrays.asList("★★★★★ MOHAMMED :Hiker's paradise.",
                                "★★★★  AMEL : Spectacular view.",
                                "★★★★  ASMA : Very good signage.",
                                "★★★★  AHMED : True connection with nature guaranteed."),
                        context.getString(R.string.mountain_yema_location))); // Add location here
                break;

            default:

        }
        return sites;
    }


}