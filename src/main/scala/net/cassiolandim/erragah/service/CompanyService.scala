package net.cassiolandim.erragah.service

import net.cassiolandim.erragah.Company

trait CompanyService {
  def insertCompany(c : Company)
  def select(id : Long) : Option[Company]
}