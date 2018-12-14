package pl.coderslab.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Player;
import pl.coderslab.repositories.PlayerRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void update(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findById(long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findByIdToArray(long id) {
        List<Player> list = new ArrayList<>();
        list.add(playerRepository.findById(id));
        return list;
    }

    @Override
    public void del(long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllActive() {
        return playerRepository.findAllByStatusEquals("ACTIVE");
    }

    @Override
    public void printPdf(Player player) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDImageXObject pdImage = PDImageXObject.createFromFile("/home/adrian/Pobrane/basketball_web_horizontal.jpg", document);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 625,620,250);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 30);
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(100, 570);
            contentStream.newLine();
            contentStream.showText("Registration card: ");
            contentStream.moveTextPositionByAmount(0, -40);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);
            contentStream.showText("Name Surname: " + player.getFullName());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Year of birth: " + player.getBirthYear());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Phone number: " + player.getPhoneNumber());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Email: " + player.getEmail());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Address: " + player.getFullAddress());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Zip-code: " + player.getCode_address());
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("Number of trainings a week: " + player.getNumberOfTrainings().toString().toLowerCase());
            contentStream.moveTextPositionByAmount(0, -36);
            contentStream.showText("Regulations:");
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("1) Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("2) Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("3) Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("4) Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            contentStream.moveTextPositionByAmount(0, -24);
            contentStream.showText("5) Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 10);
            contentStream.moveTextPositionByAmount(300, -200);
            contentStream.showText(".......................");
            contentStream.moveTextPositionByAmount(0, -12);
            contentStream.showText("Sign and Date");

            contentStream.endText();

            contentStream.close();


            document.save("Karta" + player.getFirstName() + player.getSecondName() + player.getId() + ".pdf");
            document.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
