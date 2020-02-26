package daggers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Database {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    Database() {
        System.out.println("Creating a new " + this);
    }

    public Account getAccount(String userName) {
        return accounts.computeIfAbsent(userName, Account::new);
    }

    public static final class Account {
        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;

        Account(String username) {
            this.username = username;
        }

        public String username() {
            return username;
        }

        public void deposit(BigDecimal d) {
            balance = balance.add(d);
        }

        public BigDecimal balance() {
            return balance;
        }
    }
}
