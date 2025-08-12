package pe.mil.ejercito.lib.utils.services.interfaces;

/**
 * IGetByCodeDomainEntity
 * <p>
 * IGetByCodeDomainEntity interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 22/02/2024
 */
public interface IGetByCodeDomainEntity<E, I> {
    E getByCodeEntity(I code);
}
