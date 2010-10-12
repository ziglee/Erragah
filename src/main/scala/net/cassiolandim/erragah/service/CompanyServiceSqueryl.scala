package net.cassiolandim.erragah.service

import org.squeryl.PrimitiveTypeMode._
import net.cassiolandim.erragah.Company
import net.cassiolandim.erragah.ErragahDb

class CompanyServiceSqueryl extends CompanyService {
  
  def insertCompany(company : Company) {
    inTransaction {
      ErragahDb.companies.insert(company)
    }
  }
  
  def select(id : Long): Option[Company] = {
    inTransaction {
      ErragahDb.companies.lookup(id)
    }
  }
}