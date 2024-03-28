class Bank(balance: LongArray) {
    private val balanceOfAccounts = balance
    private val accountsToBalance: HashMap<Int, Long> = hashMapOf()

    init {
        balanceOfAccounts.forEachIndexed { index, i ->
            accountsToBalance[index + 1] = i
        }
    }

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (accountIsFound(account1) && accountIsFound(account2)) {
            if(accountHaveMoneyToTransaction(account1,money))
            {
                accountsToBalance[account1] = accountsToBalance[account1]!! - money
                accountsToBalance[account2] = accountsToBalance[account2]!! + money
                return true
            }
        }
        return false
    }

    fun deposit(account: Int, money: Long): Boolean {
        if(accountIsFound(account))
        {
            accountsToBalance[account] = accountsToBalance[account]!! + money
            return true
        }
        return false
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if(accountIsFound(account))
        {
            if(accountHaveMoneyToTransaction(account,money)){
                accountsToBalance[account] = accountsToBalance[account]!! - money
                return true
            }
        }
        return false
    }

    private fun accountIsFound(account: Int): Boolean {
        return account >= 1 && account <= balanceOfAccounts.size
    }

    private fun accountHaveMoneyToTransaction(account: Int, money: Long): Boolean {
        return accountsToBalance[account]!! >= money
    }
}
/**
 * Your Bank object will be instantiated and called as such:
 * var obj = Bank(balance)
 * var param_1 = obj.transfer(account1,account2,money)
 * var param_2 = obj.deposit(account,money)
 * var param_3 = obj.withdraw(account,money)
 */