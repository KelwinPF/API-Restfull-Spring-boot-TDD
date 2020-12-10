package com.wallet.repository;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;
import com.wallet.util.TypeEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItemRepositoryTest{

    private static final Date DATE = new Date();
    private static final TypeEnum TYPE =  TypeEnum.EN;
    private static final String DESCRIPTION = "Conta de Luz";
    private static final BigDecimal VALUE = BigDecimal.valueOf(65);
    private Long savedWalletItemId = null;
    private Long savedWalletId = null;

    WalletItemRepository repo;
    @Autowired
    WalletRepository repo2;

    @Before
    public void setUp() {
        Wallet w = new Wallet();
        w.setName("Carteira Teste");
        w.setValue(BigDecimal.valueOf(250));
        repo2.save(w);

        WalletItem wi = new WalletItem();
        wi.setId(1L);
        wi.setDate(DATE);
        wi.setType(TYPE);
        wi.setDescription(DESCRIPTION);
        wi.setValue(VALUE);
        wi.setWallet(w);
        repo.save(wi);

        savedWalletItemId = wi.getId();
        savedWalletId = w.getId();
    }

    @After
    public void tearDown() {
        repo.deleteAll();
        repo2.deleteAll();
    }


    @Test
    public void testSave(){
        Wallet w = new Wallet();
        w.setName("Carteira Teste");
        w.setValue(BigDecimal.valueOf(250));
        repo2.save(w);
        
        WalletItem wi = new WalletItem();
        wi.setId(1L);
        wi.setDate(DATE);
        wi.setType(TYPE);
        wi.setDescription(DESCRIPTION);
        wi.setValue(VALUE);
        wi.setWallet(w);

        WalletItem response = repo.save(wi);
        assertNotNull(response);
        assertEquals(response.getDescription(),DESCRIPTION);
        assertEquals(response.getType(),TYPE);
        assertEquals(response.getValue(),VALUE);
        assertEquals(response.getWallet().getId(),w.getId());

    }

    @Test(expected = ConstraintViolationException.class)
    public void testSaveInvalidWalletItem() {
        WalletItem wi = new WalletItem();
        wi.setId(null);
        wi.setDate(DATE);
        wi.setType(null);
        wi.setDescription(DESCRIPTION);
        wi.setValue(null);
        wi.setWallet(null);
        repo.save(wi);
    }

    @Test
    public void testUpdate() {
        Optional<WalletItem> wi = repo.findById(savedWalletItemId);

        String description = "Descrição alterada";

        WalletItem changed = wi.get();
        changed.setDescription(description);

        repo.save(changed);

        Optional<WalletItem> newWalletItem = repo.findById(savedWalletItemId);

        assertEquals(description, newWalletItem.get().getDescription());
    }

    @Test
    public void deleteWalletItem() {
        Optional<Wallet> wallet = repo2.findById(savedWalletId);
        WalletItem wi = new WalletItem();
        wi.setId(null);
        wi.setDate(DATE);
        wi.setType(TYPE);
        wi.setDescription(DESCRIPTION);
        wi.setValue(VALUE);
        wi.setWallet(wallet.get());

        repo.save(wi);

        repo.deleteById(wi.getId());

        Optional<WalletItem> response = repo.findById(wi.getId());

        assertFalse(response.isPresent());
    }

    @Test
    public void testFindBetweenDates() {
        Optional<Wallet> w = repo2.findById(savedWalletId);

        LocalDateTime localDateTime = DATE.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        Date currentDatePlusFiveDays = Date.from(localDateTime.plusDays(5).atZone(ZoneId.systemDefault()).toInstant());
        Date currentDatePlusSevenDays = Date.from(localDateTime.plusDays(7).atZone(ZoneId.systemDefault()).toInstant());

        WalletItem wi = new WalletItem();
        wi.setId(null);
        wi.setDate(currentDatePlusFiveDays);
        wi.setType(TYPE);
        wi.setDescription(DESCRIPTION);
        wi.setValue(VALUE);
        wi.setWallet(w.get());

        WalletItem wi2 = new WalletItem();
        wi2.setId(null);
        wi2.setDate(currentDatePlusSevenDays);
        wi2.setType(TYPE);
        wi2.setDescription(DESCRIPTION);
        wi2.setValue(VALUE);
        wi2.setWallet(w.get());

        repo.save(wi);
        repo.save(wi2);

        PageRequest pg = PageRequest.of(0, 10);
        Page<WalletItem> response = repo.findAllByWalletIdAndDateGreaterThanEqualAndDateLessThanEqual(savedWalletId, DATE, currentDatePlusFiveDays, pg);

        assertEquals(response.getContent().size(), 2);
        assertEquals(response.getTotalElements(), 2);
        assertEquals(response.getContent().get(0).getWallet().getId(), savedWalletId);
    }

    @Test
    public void testFindByType() {
        List<WalletItem> response = repo.findByWalletIdAndType(savedWalletId, TYPE);

        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getType(), TYPE);
    }

    @Test
    public void testFindByTypeSd() {

        Optional<Wallet> w = repo2.findById(savedWalletId);
        WalletItem wi = new WalletItem();
        wi.setId(null);
        wi.setDate(DATE);
        wi.setType(TypeEnum.SD);
        wi.setDescription(DESCRIPTION);
        wi.setValue(VALUE);
        wi.setWallet(w.get());

        repo.save(wi);

        List<WalletItem> response = repo.findByWalletIdAndType(savedWalletId, TypeEnum.SD);

        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getType(), TypeEnum.SD);
    }

    @Test
    public void testSumByWallet() {
        Optional<Wallet> w = repo2.findById(savedWalletId);

        WalletItem wi = new WalletItem();
        wi.setId(null);
        wi.setDate(DATE);
        wi.setType(TYPE);
        wi.setDescription(DESCRIPTION);
        wi.setValue(BigDecimal.valueOf(150.80));
        wi.setWallet(w.get());

        repo.save(wi);

        BigDecimal response = repo.sumByWalletId(savedWalletId);

        assertEquals(response.compareTo(BigDecimal.valueOf(215.8)), 0);
    }
}
