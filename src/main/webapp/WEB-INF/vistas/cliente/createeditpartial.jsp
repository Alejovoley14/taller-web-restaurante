<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<th:input path="Latitud" type="hidden"></th:input>
<th:input path="Longitud" type="hidden"></th:input>

<div class="row">
    <div class="col-sm-12" align="center">
        <div>
            <label class="btn btn-info btn-file">
                Seleccionar... <input type="file" name="photo" id="photo" hidden> |
                <i class="fa fa-file" aria-hidden="true"></i>
            </label>
        </div>
    </div>

</div>
<hr>
<div class="row">
    <div class="col-sm-12 col-md-5">
        <h3>Datos Personales</h3>
        <div class="row">
            <div class="form-group">
                <label for="nombre" class="col-sm-2 col-md-3 control-label">Nombre</label>
                <div class="col-sm-10 col-md-9">
                    <input type="text" id="nombre" name="nombre" class="form-control"
                           value="{{!empty($perfil) ? $perfil->nombre :'' }}">
                    @if ($errors->has('nombre'))
                    <span class="help-block">
                    <strong>{{ $errors->first('nombre') }}</strong>
                </span>
                    @endif
                </div>
            </div>
            <div class="form-group">
                <label for="apellido" class="col-sm-2 col-md-3 control-label">Apellido</label>
                <div class="col-sm-10 col-md-9">
                    <input type="text" id="apellido" name="apellido" class="form-control"
                           value="{{!empty($perfil) ? $perfil->apellido :'' }}">
                    @if ($errors->has('apellido'))
                    <span class="help-block">
                    <strong>{{ $errors->first('apellido') }}</strong>
                </span>
                    @endif
                </div>
            </div>
            <div class="form-group">
                <label for="fechanacimiento" class="col-sm-2 col-md-3 control-label">Fecha de Nacimiento</label>
                <div class="col-sm-10 col-md-9">
                    <div class="input-group date">
                        <input type="text" id="fechanacimiento" name="fechanacimiento" class="form-control"
                               value="{{!empty($perfil) ? $perfil->fechanacimiento :'' }}">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>
                    </div>
                    @if ($errors->has('fechanacimiento'))
                    <span class="help-block">
                    <strong>{{ $errors->first('fechanacimiento') }}</strong>
                </span>
                    @endif
                </div>
            </div>
            <div class="form-group">
                <label for="telefono" class="col-sm-2 col-md-3 control-label">Telefono</label>
                <div class="col-sm-10 col-md-9">
                    <input type="tel" id="telefono" name="telefono" class="form-control"
                           value="{{!empty($perfil) ? $perfil->telefono :'' }}">
                    @if ($errors->has('telefono'))
                    <span class="help-block">
                    <strong>{{ $errors->first('telefono') }}</strong>
                </span>
                    @endif
                </div>
            </div>
            <div class="form-group">
                <label for="sexo_id" class="col-sm-2 col-md-3 control-label">Telefono</label>
                <div class="col-sm-10 col-md-9">
                    <select id="sexo_id" name="sexo_id" class="form-control">
                        @foreach( $sexos as $sexo)
                        <option value="{{$sexo->id}}" {{!empty($perfil) && $perfil->sexo_id == $sexo->id ? 'selected="selected"' :'' }}>{{$sexo->descripcion}}</option>
                        @endforeach
                    </select>
                    @if ($errors->has('telefono'))
                    <span class="help-block">
                    <strong>{{ $errors->first('telefono') }}</strong>
                </span>
                    @endif
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-12 col-md-offset-1 col-md-5">
        <h3>Domicilio</h3>
        <div class="row">
            <div class="form-group">
                <label for="provinciaId" class="col-sm-2 col-md-3 control-label">Provincia</label>
                <div class="col-sm-10 col-md-9">
                    <select id="provinciaId" name="provinciaId" class="form-control">
                        <option>Seleccione una provincia...</option>
                        @foreach( $provincias as $provincia)
                        <option value="{{$provincia->id}}">{{$provincia->descripcion}}</option>
                        @endforeach
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="departamentoId" class="col-sm-2 col-md-3 control-label">Departamento</label>
                <div class="col-sm-10 col-md-9">
                    <select id="departamentoId" name="departamentoId" class="form-control">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="localidad_id" class="col-sm-2 col-md-3 control-label">Localidad</label>
                <div class="col-sm-10 col-md-9">
                    <select id="localidad_id" name="localidad_id" class="form-control">
                    </select>
                </div>
            </div>
            <div class="row input-group">

                <label for="calle" class="col-sm-2 col-md-2 control-label">Calle</label>
                <div class="col-sm-10 col-md-5">
                    <input type="text" id="calle" name="calle" class="form-control"
                           value="{{!empty($domicilio) ? $domicilio->calle :'' }}">
                    @if ($errors->has('calle'))
                    <span class="help-block">
                    <strong>{{ $errors->first('calle') }}</strong>
                </span>
                    @endif
                </div>
                <label for="numero" class="col-sm-2 col-md-2 control-label">Nro</label>
                <div class="col-sm-9 col-md-2">
                    <input type="text" id="numero" name="numero" class="form-control"
                           value="{{!empty($domicilio) ? $domicilio->numero :'' }}">
                    @if ($errors->has('numero'))
                    <span class="help-block"><strong>{{ $errors->first('numero') }}</strong></span>
                    @endif
                </div>
                <div class="col-sm-1">
                    <button type="button" id="btnSetMarker" class="btn btn-info"><span
                            class="glyphicon glyphicon-map-marker"></span></button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-offset-3 col-sm-6">
        <div class="panel">
            <div class="panel-body">
                <div id="map" class="embed-responsive-16by9"></div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-offset-9 col-sm-3">
        <button class="btn btn-primary" type="submit">Guardar</button>
    </div>
</div>

