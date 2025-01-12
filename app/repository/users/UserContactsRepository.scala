package repository.users

import domain.users.UserContacts
import repository.Repository
import repository.users.impl.cockroachdb

trait UserContactsRepository extends Repository[UserContacts]{

}

object UserContactsRepository{
  def roach: UserContactsRepository = new cockroachdb.UserContactsRepositoryImpl()
}
